package edu.springboot.OrderService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;

import edu.springboot.OrderService.dto.OrderLineItemsDto;
import edu.springboot.OrderService.dto.OrderRequest;
import edu.springboot.OrderService.model.Order;
import edu.springboot.OrderService.model.OrderLineItems;
import edu.springboot.OrderService.model.OrderLineItems.OrderLineItemsBuilder;
import edu.springboot.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService
{
	private final OrderRepository repo;

	public void placeOrder(OrderRequest orderRequest) {
		System.out.println(orderRequest);
		List<OrderLineItemsDto> olidto=orderRequest.getOrderLineItemsDto();
		List<OrderLineItems> oli=new ArrayList<>();
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		for(OrderLineItemsDto i:olidto) {
			oli.add(mapToOrderLineItems(i));
		}
		order.setOrderLineItems(oli);
		System.out.println(order);
//		order.setOrderLineItems(orderRequest.getOrderLineItemsDto());
		// TODO Auto-generated method stub
		repo.save(order);
		
		
	}

	private OrderLineItems mapToOrderLineItems(OrderLineItemsDto i) {
		// TODO Auto-generated method stub
		
//		OrderLineItems oli_obj=OrderLineItems.builder().
//				id(i.getId()).productName(i.getProductName()).
//				productPrice(i.getProductPrice()).
//				productQuantity(i.getProductQuantity()).build();
		OrderLineItems oli_obj=OrderLineItems.builder()
				.productName(i.getProductName())
				.productPrice(i.getProductPrice())
				.productQuantity(i.getProductQuantity()).build();
		
		return oli_obj;
	}
	

}
