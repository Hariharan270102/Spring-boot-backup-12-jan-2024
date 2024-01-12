package edu.springboot.OrderService.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import edu.springboot.OrderService.dto.InvetoryRequest;
import edu.springboot.OrderService.dto.OrderLineItemsDto;
import edu.springboot.OrderService.dto.OrderRequest;
import edu.springboot.OrderService.dto.ProductResponse;
import edu.springboot.OrderService.model.Order;
import edu.springboot.OrderService.model.OrderLineItems;
import edu.springboot.OrderService.model.OrderLineItems.OrderLineItemsBuilder;
import edu.springboot.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import edu.springboot.OrderService.dto.InvetoryRequest;
@Service
@RequiredArgsConstructor
public class OrderService
{
	private final OrderRepository repo;
	
	private final WebClient.Builder webClientBuilder;

	public String placeOrder(OrderRequest orderRequest) {
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

//		repo.save(order);
		
		List<String> productNames=order.getOrderLineItems().stream().
				map(orderItemList->orderItemList.getProductName()).toList();
		
		InvetoryRequest[] inventoryResponsetArray= webClientBuilder.build().get()
		.uri("http://inventory-service/inventory",uriBuilder->uriBuilder.queryParam("productNames",productNames)
		.build()).retrieve().bodyToMono(InvetoryRequest[].class).block();
		
		boolean stockCheckStatus=Arrays.stream(inventoryResponsetArray).allMatch(inventory->inventory.isProductQuantity());
		
		String msg="";
		if(stockCheckStatus) {
			repo.save(order);
			msg="ORDER PLACED SUCCESSFULLY!!!";
			
		}
		else{
			msg="SOME OF THE PRODUCTS ARE OUT OF STOCK";
//			throw new IllegalArgumentException("SOME OF THE PRODUCTS ARE OUT OF STOCK");
		}
		return msg;
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

	
	public List<ProductResponse> viewProducts() {
		ProductResponse[] productResponseArray=webClientBuilder.build().get()
		.uri("http://product-service/product").retrieve().bodyToMono(ProductResponse[].class).block();
		
		return Arrays.asList(productResponseArray);
		// TODO Auto-generated method stub
		
	}
	
	
	

}
