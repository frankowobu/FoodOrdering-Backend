package com.usl.delivery_app.dto.OrdersDto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private Long userId;
    private double orderTotal;
    private String orderAddress;
    private String orderPhone;
    private List<Long> mealIds; // changed from List<Meal> meals

    public OrderRequestDto(Long userId, double orderTotal, String orderAddress, String orderPhone, List<Long> mealIds) {
        this.userId = userId;
        this.orderTotal = orderTotal;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.mealIds = mealIds;
    }
}