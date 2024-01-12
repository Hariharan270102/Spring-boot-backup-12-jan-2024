package edu.springboot.OrderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.OrderService.dto.OrderLineItemsDto;
import edu.springboot.OrderService.dto.OrderRequest;
import edu.springboot.OrderService.model.OrderLineItems;
import edu.springboot.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderFrontController {
	@Autowired
	OrderService eService;
	
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		eService.placeOrder(orderRequest);
		return "Order Placed Successfully";
		
	}
	
	

}
