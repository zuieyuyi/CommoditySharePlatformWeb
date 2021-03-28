package com.commodityshareplatform.web.order.server;

import com.commodityshareplatform.web.order.bean.Order;

import java.util.List;

public interface IOrderService {
    public List<Order> selectAllOrders();

    public Order selectOrderById(Integer id);

    public Integer deleteOrderById(Integer id);

    public Integer updateOrder(Order order);

    public Integer insertOrder(Order order);

    public Integer deleteOrderBatchById(List<Integer> ids);
}
