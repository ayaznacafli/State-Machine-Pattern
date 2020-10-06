package com.example.dto;

import com.example.model.OrderStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class OrderDto {
    private Long id;
    private String orderName;
    private String link;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
