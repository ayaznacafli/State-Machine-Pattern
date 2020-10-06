package com.example.service.actions.statuses;

import com.example.dto.OrderDto;
import com.example.model.OrderStatus;
import com.example.service.actions.StatusAction;
import org.springframework.stereotype.Component;

@Component
public class FaildComeStatus implements StatusAction {

    public static final String NAME = "FAILDCOME";

    @Override
    public void applyProcessing(OrderDto orderDto) {
        orderDto.setOrderStatus(getOrderStatus());
    }

    @Override
    public String getStatusName() {
        return NAME;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return OrderStatus.FIELDCOME;
    }
}