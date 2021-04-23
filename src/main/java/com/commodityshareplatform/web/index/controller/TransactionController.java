package com.commodityshareplatform.web.index.controller;

import com.commodityshareplatform.web.commodity.bean.Commodity;
import com.commodityshareplatform.web.commodity.bean.CommodityExample;
import com.commodityshareplatform.web.commodity.server.ICommodityService;
import com.commodityshareplatform.web.order.bean.Order;
import com.commodityshareplatform.web.order.server.IOrderService;
import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.server.IUserService;
import com.commodityshareplatform.web.utils.Result;
import com.commodityshareplatform.web.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    ICommodityService commodityService;
    @Autowired
    IOrderService orderService;
    @Autowired
    IUserService userService;

    /**
     * 租借商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/lease",method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 2,
            rollbackFor = {Exception.class})
    public Result lease(HttpServletRequest request) throws Exception {
        String orderPubUser = request.getParameter("orderPubUser") == null?"":request.getParameter("orderPubUser");
        Integer orderUser = (Integer) request.getSession().getAttribute("userId");
        String orderBeginRentTime = request.getParameter("orderBeginRentTime") == null?"":request.getParameter("orderBeginRentTime");
        String orderEndRentTime = request.getParameter("orderEndRentTime") == null?"":request.getParameter("orderEndRentTime");
        String orderCommodityId = request.getParameter("orderCommodityId") == null?"":request.getParameter("orderCommodityId");
        String orderCommodityNum = request.getParameter("orderCommodityNum") == null?"":request.getParameter("orderCommodityNum");
        String commodityPrice = request.getParameter("commodityPrice") == null?"":request.getParameter("commodityPrice");
        if (orderUser == null||orderUser == 0){
            return ResultUtils.error(-1,"登录失效");
        }

        if (StringUtils.isEmpty(orderPubUser)||StringUtils.isEmpty(orderBeginRentTime)||StringUtils.isEmpty(commodityPrice)
                ||StringUtils.isEmpty(orderEndRentTime) ||StringUtils.isEmpty(orderCommodityId)||StringUtils.isEmpty(orderCommodityNum)){
            return ResultUtils.error(-1,"租借失败");
        }

        //对于时间的校验
        //对于商品数量与租借数量的校验
        //对于时间的转换
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = dateFormat.parse(orderBeginRentTime);
        Date endTime = dateFormat.parse(orderEndRentTime);
        Date backTime = new Date(endTime.getTime()+(1*1000*60*60*24));/* 返还时间默认为结束时间+1天 */

        //计算总金额  天数*单价*数量
        long day = (endTime.getTime() - beginTime.getTime())/1000/60/60/24;
        int orderCommodityTotal = (int) day * Integer.parseInt(commodityPrice) * Integer.parseInt(orderCommodityNum);

        //1、生成订单
        //订单发出地址和收货地址分别为买家用户和卖家用户设置的地址，没有需要提示并且回滚
        User user = userService.selectUserById(orderUser);
        User pubUser = userService.selectUserById(Integer.parseInt(orderPubUser));

        if (StringUtils.isEmpty(user.getUserAddr()) || StringUtils.isEmpty(pubUser.getUserAddr())){
            return ResultUtils.error(-1,"卖家或者卖家未设置地址");
        }

        //订单状态orderStatus默认为1支付中
        Order order = new Order();
        order.setOrderPubUserId(Integer.parseInt(orderPubUser));
        order.setOrderUserId(orderUser);
        order.setOrderCommodityId(Integer.parseInt(orderCommodityId));
        order.setOrderBeginRentTime(beginTime);
        order.setOrderEndRentTime(endTime);
        order.setOrderCommodityNum(Integer.parseInt(orderCommodityNum));
        order.setOrderBackTime(backTime);
        order.setOrderStatus(1);
        BigDecimal total = new BigDecimal(orderCommodityTotal);
        order.setOrderCommodityTotal(total);
        order.setOrderAddr(user.getUserAddr());
        order.setOrderArriveAddr(pubUser.getUserAddr());

        orderService.insertOrder(order);
        //2、修改商品数量
        Commodity commodity = commodityService.selectCommodityById(Integer.parseInt(orderCommodityId));
        commodity.setCommodityNum(commodity.getCommodityNum() - Integer.parseInt(orderCommodityNum));
        commodityService.updateCommodity(commodity);

        //3、修改用户金额数量
        //买家
        if (pubUser.getUserMoney().compareTo(total) < 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(-1,"买家钱不够");
        }
        pubUser.setUserMoney(pubUser.getUserMoney().subtract(total));
        userService.updateUser(pubUser);

        //卖家
        user.setUserMoney(user.getUserMoney().add(total));
        userService.updateUser(user);

        return ResultUtils.success();
    }
}
