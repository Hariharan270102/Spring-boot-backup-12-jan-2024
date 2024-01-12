package edu.springboot.OrderService.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.OrderService.dto.OrderLineItemsDto;
import edu.springboot.OrderService.dto.OrderRequest;
import edu.springboot.OrderService.dto.ProductResponse;
import edu.springboot.OrderService.model.OrderLineItems;
import edu.springboot.OrderService.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderFrontController {
	@Autowired
	OrderService eService;
	
	@PostMapping
	@CircuitBreaker(name="inventory")
	@TimeLimiter(name="inventory", fallbackMethod  ="fallbackMethod")
	public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		String msg =  eService.placeOrder(orderRequest);
		
		return CompletableFuture.supplyAsync(()->msg);
//		return "Order Placed Successfully";
		
	}
	
	public CompletableFuture<String>  fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException)
	{
		System.out.println("Fall back method calling");
		
		return CompletableFuture.supplyAsync(()->"Oder can't be placed ");
	}
	
	@GetMapping("/product")
	public List<ProductResponse> viewProducts(){
		return eService.viewProducts();
//		return null;
		
	}
	
	
	

}
