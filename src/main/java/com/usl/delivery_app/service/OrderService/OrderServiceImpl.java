package com.usl.delivery_app.service.OrderService;

import com.usl.delivery_app.data.MealData.Meal;
import com.usl.delivery_app.data.OrderData.Order;
import com.usl.delivery_app.data.OrderData.OrderStatus;
import com.usl.delivery_app.data.Usersdata.Users;
import com.usl.delivery_app.repository.MealRepository;
import com.usl.delivery_app.repository.OrderRepository;
import com.usl.delivery_app.repository.UsersRepository;
import com.usl.delivery_app.service.OrderService.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UsersRepository usersRepository;
    private MealRepository mealRepository;


    @Override
    public Order createOrder(Long userId,  String orderAddress, String orderPhone, List<Long> mealIds) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Order order = new Order();
        order.setUser(user);
        order.setOrderTotal(
                mealIds.stream().mapToDouble(mealId -> mealRepository.findById(mealId).orElseThrow(() -> new RuntimeException("Meal not found")).getMealPrice()).sum()
        );
        order.setOrderAddress(orderAddress);
        order.setOrderPhone(orderPhone);
        order.setTrackingNumber("TRK" + new Date().getTime());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setMeals(new ArrayList<>());
        mealIds.forEach(mealId -> {
            Meal meal = mealRepository.findById(mealId).orElseThrow(() -> new RuntimeException("Meal not found"));
            order.getMeals().add(meal);
        });
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getOrders();
    }

    @Override
    public List<Order> getAllOrders() {
       List<Order>  order =  orderRepository.findAll();
       return order;
    }
}
