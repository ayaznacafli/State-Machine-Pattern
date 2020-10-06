package com.example.service.actions.statuses;

import com.example.dto.OrderDto;
import com.example.model.OrderStatus;
import com.example.service.actions.StatusAction;
import org.springframework.stereotype.Component;

@Component
public class ForeignStatus implements StatusAction {
    @Override
    public void applyProcessing(OrderDto orderDto) {

    }

    @Override
    public String getStatusName() {
        return null;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return null;
    }
}