package com.example.service;

import com.example.dto.OrderDto;
import com.example.model.Order;

import java.util.List;

public interface OrderService {
    OrderDto addOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
    void updateOrder(OrderDto orderDto);
    List<String> getAllowedActions(Long id);
    OrderDto actionOrder(OrderDto orderDto, String action);
}
