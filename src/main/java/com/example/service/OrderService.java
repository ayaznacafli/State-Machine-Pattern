package com.example.service;

import com.example.dto.OrderDto;

public interface OrderService {
    OrderDto addOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto, String status);
}
