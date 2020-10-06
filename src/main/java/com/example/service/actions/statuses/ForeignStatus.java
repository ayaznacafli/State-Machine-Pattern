package com.example.service.actions.statuses;

import com.example.dto.OrderDto;
import com.example.model.OrderStatus;
import com.example.service.actions.StatusAction;
import org.springframework.stereotype.Component;

@Component
public class ForeignStatus implements StatusAction {

    public static final String NAME = "FOREIG";

    @Override
    public void applyProcessing(OrderDto orderDto) {

    }

    @Override
    public String getStatusName() {
        return NAME;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return null;
    }
}