package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private String link;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
