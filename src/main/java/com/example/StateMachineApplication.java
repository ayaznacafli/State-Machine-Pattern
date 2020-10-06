package com.example;

import com.example.dto.OrderDto;
import com.example.model.Order;
import com.example.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StateMachineApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StateMachineApplication.class, args);
		OrderService service = context.getBean(OrderService.class);

		OrderDto orderDto = new OrderDto();
		orderDto.setLink("ww.trendyol.com");
		orderDto.setOrderName("Ayaqqabi");
	//	OrderDto dto = service.addOrder(orderDto);
		orderDto.setId(1L);
		OrderDto dto = service.updateOrder(orderDto,"PENDING");
		System.out.println(dto);
	}

}
