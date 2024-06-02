package com.usl.delivery_app.dto.OrdersDto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private Long userId;

    private String orderAddress;
    private String orderPhone;
    private List<Long> mealIds;

    public OrderRequestDto(Long userId,  String orderAddress, String orderPhone, List<Long> mealIds) {
        this.userId = userId;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.mealIds = mealIds;
    }
}