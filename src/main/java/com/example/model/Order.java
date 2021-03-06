package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_table")
public class Order {

  //  @GeneratedValue(strategy=GenerationType.AUTO, generator = "order_Sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderName;
    private String link;

 //   @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
