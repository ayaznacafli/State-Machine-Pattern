package com.example.service.actions;

import com.example.dto.OrderDto;
import com.example.model.OrderStatus;

public interface StatusAction {
    void applyProcessing(OrderDto orderDto);
    String getStatusName();
    OrderStatus getOrderStatus();
}
