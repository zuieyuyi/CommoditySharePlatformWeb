package com.commodityshareplatform.web.order.server.impl;

import com.commodityshareplatform.web.commodity.bean.Commodity;
import com.commodityshareplatform.web.commodity.bean.CommodityExample;
import com.commodityshareplatform.web.commodity.dao.CommodityMapper;
import com.commodityshareplatform.web.commodity.server.ICommodityService;
import com.commodityshareplatform.web.enuminfo.OrderStatusEnum;
import com.commodityshareplatform.web.order.bean.Order;
import com.commodityshareplatform.web.order.bean.OrderExample;
import com.commodityshareplatform.web.order.dao.OrderMapper;
import com.commodityshareplatform.web.order.server.IOrderService;
import com.commodityshareplatform.web.user.bean.User;
import com.commodityshareplatform.web.user.dao.UserMapper;
import com.commodityshareplatform.web.user.server.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    IUserService userService;
    @Autowired
    ICommodityService commodityService;

    @Override
    public List<Order> selectAllOrders(OrderExample example) {
        CommodityExample commodityExample = new CommodityExample();
        List<Order> orders = orderMapper.selectByExample(example);
        List<User> users = userMapper.selectAllUsers();
        List<Commodity> commodities = commodityMapper.selectAllCommodities(commodityExample);

        for (Order order:orders){
            //确定订单状态信息
            if (order.getOrderStatus() == OrderStatusEnum.PAYMENT.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.PAYMENT.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.TAKE_DELIVERY.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.TAKE_DELIVERY.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.RENT_OUT.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.RENT_OUT.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.RETURN.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.RETURN.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.RETURN_OVER.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.RETURN_OVER.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.NO_TAKE_DELIVERY.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.NO_TAKE_DELIVERY.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.NO_RETURN.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.NO_RETURN.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.TAKE_RECEIPT.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.TAKE_RECEIPT.getStatus());
            }else if (order.getOrderStatus() == OrderStatusEnum.NO_TAKE_RECEIPT.getStatusCode()){
                order.setOrderStatusMsg(OrderStatusEnum.NO_TAKE_RECEIPT.getStatus());
            }

            for (User user:users){
                //确认订单卖家
                if (user.getUserId()==order.getOrderUserId()){
                    order.setOrderUserName(user.getUserName());
                }
                //确认订单买家
                if (user.getUserId()==order.getOrderPubUserId()){
                    order.setOrderPubUserName(user.getUserName());
                }
//                if ((!"".equals(order.getOrderUserName()))&&(!"".equals(order.getOrderPubUserName()))){
//                    break;
//                }
            }

            for (Commodity commodity:commodities){
                //确认商品信息
                if (commodity.getCommodityId() == order.getOrderCommodityId()){
                    order.setOrderCommodityName(commodity.getCommodityName());
                    break;
                }
            }
        }

        return orders;
    }

    @Override
    public Order selectOrderById(Integer id) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdEqualTo(id);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        Order order = orders.get(0);

        User user = userService.selectUserById(order.getOrderUserId());
        User pubUser = userService.selectUserById(order.getOrderPubUserId());
        Commodity commodity = commodityService.selectCommodityById(order.getOrderCommodityId());

        if (user != null){
            order.setOrderUserName(user.getUserName());
        }
        if (pubUser != null){
            order.setOrderPubUserName(pubUser.getUserName());
        }
        if (commodity != null){
            order.setOrderCommodityName(commodity.getCommodityName());
        }
        return order;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 2,
            rollbackFor = {Exception.class})
    @Override
    public Integer deleteOrderById(Integer id) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdEqualTo(id);

        Order order = selectOrderById(id);
        order.setIsValid(0);
        int result = orderMapper.updateByExample(order, orderExample);
        return result;
    }

    @Override
    public Integer updateOrder(Order order) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdEqualTo(order.getOrderId());

//        Order order1 = selectOrderById(order.getOrderId());
//        order1.setOrderName(order.getOrderName());
//        order.setOrderPubUserId(order.getOrderPubUserId());
//        order.setOrderUserId(order.getOrderUserId());
//        order.setOrderCommodityId(order.getOrderCommodityId());
//        order.setOrderStatus(order.getOrderStatus());
//        order.setOrderAddr(order.getOrderAddr());
//        order.setOrderArriveAddr(order.getOrderArriveAddr());
//        order.setOrderBeginRentTime(order.getOrderBeginRentTime());
//        order.setOrderEndRentTime(order.getOrderEndRentTime());
//        order.setOrderBackTime(order.getOrderBackTime());

        int result = orderMapper.updateByExampleSelective(order, orderExample);
        return result;
    }

    @Override
    public Integer insertOrder(Order order) {
        Date date = new Date();
        String orderCode;
        long count = 0;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        //订单编号根据时间+三位随机数生成订单编号
        do{
            Integer number = (int) (Math.random() * 1000);
            orderCode = date.getTime()+number+"";
            criteria.andOrderCodeEqualTo(orderCode);
            count = orderMapper.countByExample(orderExample);
        }while (count != 0);

        order.setOrderCode(orderCode);
        order.setOrderCreateDate(date);
        int result = orderMapper.insertSelective(order);
        return result;
    }

    @Override
    public Integer deleteOrderBatchById(List<Integer> ids) {
        return null;
    }
}
