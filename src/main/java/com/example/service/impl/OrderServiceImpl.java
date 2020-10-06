package com.example.service.impl;

import com.example.dto.OrderDto;
import com.example.model.Order;
import com.example.model.OrderStatus;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import com.example.service.actions.StatusAction;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {

    private Map<String, StatusAction> statusActionMap;

    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(ModelMapper modelMapper,ApplicationEventPublisher applicationEventPublisher,OrderRepository orderRepository) {
        this.modelMapper = modelMapper;
        this.applicationEventPublisher = applicationEventPublisher;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public void updateOrder(OrderDto orderDto) {

    }

    @Override
    public List<String> getAllowedActions(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unknown order: "+id));
        return order.getOrderStatus().getStatuses();
    }

    @Transactional
    public OrderDto actionOrder(OrderDto orderDto, String action) {
        StatusAction statusAction = statusActionMap.get(action.toLowerCase());
        if(statusAction == null) {
            throw new IllegalArgumentException("Unknown action: " + action);
        }
        return orderRepository.findById(orderDto.getId())
                .map(order -> {
                    checkAllowed(statusAction,order.getOrderStatus());
                    statusAction.applyProcessing(modelMapper.map(order, OrderDto.class));
                    return updateStatus(order,statusAction.getOrderStatus());
                })
                .map(o -> modelMapper.map(o, OrderDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Unknown order: "+orderDto.getId()));
    }

    private Order updateStatus(Order order, OrderStatus updateStatus) {
        OrderStatus orderStatus =  order.getOrderStatus();
        order.setOrderStatus(updateStatus);
        return orderRepository.save(order);
    }

    private void checkAllowed(StatusAction statusAction, OrderStatus orderStatus) {
        Set<OrderStatus> allowedSourceStatuses = Stream.of(OrderStatus.values())
                .filter(status -> status.getStatuses().contains(statusAction.getStatusName()))
                .collect(Collectors.toSet());
        if(!allowedSourceStatuses.contains(orderStatus)) {
            throw new RuntimeException("The transition from the "+ orderStatus.name() +" status to the"
                                       + statusAction.getOrderStatus().name() + " status is not allowed");
        }
    }

    private void initActions(List<StatusAction> statusActions) {
        Map<String,StatusAction> actionMap = new HashMap<>();
        for (StatusAction statusAction : statusActions) {
            if(actionMap.containsKey(statusAction.getStatusName())) {
                throw new IllegalStateException("Dublicate transition"+statusAction.getStatusName());
            }
            actionMap.put(statusAction.getStatusName(),statusAction);
        }
        statusActionMap = Collections.unmodifiableMap(actionMap);
    }
}
