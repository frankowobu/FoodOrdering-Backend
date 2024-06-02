package com.usl.delivery_app.service.OrderService;

import com.usl.delivery_app.data.OrderData.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long userId, Double orderTotal, String orderAddress, String orderPhone, List<Long> meal);
    Order getOrder(Long orderId);
    List<Order> getOrdersByUser(Long userId);
    List<Order> getAllOrders();
}
