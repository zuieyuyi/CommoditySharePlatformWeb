package com.commodityshareplatform.web.order.controller;

import com.commodityshareplatform.web.order.bean.Order;
import com.commodityshareplatform.web.order.bean.OrderExample;
import com.commodityshareplatform.web.order.server.IOrderService;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    /**
     * 获取全部订单数据
     */
    @RequestMapping(value = "orders", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllOrders() {
        List<Order> orders = orderService.selectAllOrders(new OrderExample());
        return ResultUtils.success(orders);
    }

    /**
     * 获取全部订单数据(分页)
     */
    @RequestMapping(value = "orderss", method = RequestMethod.GET)
    @ResponseBody
    public Result<PageInfo> getOrderss(@RequestParam("pn") Integer pn,@RequestParam(value = "ps",defaultValue = "5") Integer ps, HttpServletRequest request) {
        PageHelper.startPage(pn, ps);

        String userId = request.getParameter("userId") == null?"":request.getParameter("userId");
        String pubUserId = request.getParameter("pubUserId") == null?"":request.getParameter("pubUserId");

        //过滤条件
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(userId)){
            criteria.andOrderUserIdEqualTo(Integer.parseInt(userId));
        }
        if (!StringUtils.isEmpty(pubUserId)){
            OrderExample.Criteria criteria1 = example.createCriteria();
            criteria1.andOrderPubUserIdEqualTo(Integer.parseInt(pubUserId));
            example.or(criteria1);
        }

        List<Order> orders = orderService.selectAllOrders(example);
        PageInfo pageInfo = new PageInfo(orders, ps);
        return ResultUtils.success(pageInfo);
    }

    /**
     * 添加订单
     */
    @RequestMapping(value = "order" ,method = RequestMethod.POST)
    @ResponseBody
    public Result addOrder(Order order){
        Integer result = orderService.insertOrder(order);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"订单添加失败添加失败");
        }
    }

    /**
     * 通过Id查询对应的订单
     */
    @RequestMapping(value = "order/{orderId}",method = RequestMethod.GET)
    @ResponseBody
    public Result getOrderById(@PathVariable("orderId") Integer orderId){
        Order order = orderService.selectOrderById(orderId);
        return ResultUtils.success(order);
    }

    /**
     * 保存修改的订单
     */
    @RequestMapping(value = "order",method = RequestMethod.PUT)
    @ResponseBody
    public Result saveOrder(Order order){
        Integer result = orderService.updateOrder(order);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"订单保存失败添加失败");
        }
    }

    /**
     * 删除订单
     */
    @RequestMapping(value = "order/{orderId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteOrder(@PathVariable("orderId") Integer orderId){
        Integer result = orderService.deleteOrderById(orderId);
        if (result != null){
            return ResultUtils.success();
        }else{
            return ResultUtils.error(-1,"订单保存失败添加失败");
        }
    }
}
