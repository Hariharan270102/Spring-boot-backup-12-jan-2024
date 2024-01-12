package edu.springboot.ProductService.service;

import java.util.ArrayList;
import edu.springboot.ProductService.dto.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.springboot.ProductService.model.Product;
import edu.springboot.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  //spring creates anonymous class and creates an object for us 
public class ProductService 
{
	
	private final ProductRepository repo;
	
	private final WebClient.Builder webClientBuilder;
	
	
	
	
//	ProductResponse productResponse;
	
	public String createNewProduct(ProductRequest productRequest) throws JsonProcessingException {
		Product productPojo=new Product();
		productPojo.setProductName(productRequest.getProductName());
		productPojo.setProductPrice(productRequest.getProductPrice());
		productPojo.setProductQuantity(productRequest.getProductQuantity());
		System.out.println(productPojo);
		repo.save(productPojo);
		InventoryRequestOriginal inReqOrgObj = new InventoryRequestOriginal();

		inReqOrgObj.setProductName(productRequest.getProductName());
		inReqOrgObj.setProductQuantity(productRequest.getProductQuantity());
		System.out.println(inReqOrgObj);
		//The ObjectMapper is a Jackson library class used for converting Java objects to JSON and vice versa.
		ObjectMapper objectMapper=new ObjectMapper();
		webClientBuilder.build().post().uri("http://inventory-service/inventory").contentType(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromValue(objectMapper.writeValueAsString(inReqOrgObj))).retrieve().toBodilessEntity()
		.block();
//		InventoryRequestOriginal inventoryRequestOriginalObj= webClient.post().uri("http://localhost:8003/inventory",uriBuilder ->uriBuilder.queryParam("invobj",inReqOrgObj )
//				.build()).retrieve().bodyToMono(InventoryRequestOriginal.class).block();
//		
//		((Object) webClient.post().attribute("invRequestOrg", inventoryRequestOriginalObj)).bodyToMono(InventoryRequestOriginal.class).block();;
		return "Product Added";

	}

	public List<ProductResponse> getAllProducts() {
		List<Product> pl=repo.findAll();
		List<ProductResponse> rl=new ArrayList<>();
		for(Product i:pl) {
			rl.add(mapToProductResponse(i));
		}
		return rl;
		
		// TODO Auto-generated method stub
		
	}

	private ProductResponse mapToProductResponse(Product product) {
		ProductResponse productResponse =new ProductResponse();
		productResponse.setProductId(product.getProductId());
		productResponse.setProductName(product.getProductName());
		productResponse.setProductPrice(product.getProductPrice());
		productResponse.setProductQuantity(product.getProductQuantity());
		// TODO Auto-generated method stub
		return productResponse;
	}

}
