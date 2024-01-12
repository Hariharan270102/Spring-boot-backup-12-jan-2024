package edu.springboot.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.springboot.ProductService.dto.ProductRequest;
import edu.springboot.ProductService.dto.ProductResponse;
import edu.springboot.ProductService.model.Product;
import edu.springboot.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductFrontController
{
	
	@Autowired
	ProductService eService;
	
	@PostMapping
	public String createProduct(@RequestBody ProductRequest productRequest) throws JsonProcessingException 
	{
		return eService.createNewProduct(productRequest);
	}
	
//	@GetMapping
//	public List<Product> getAllProducts() {
//		List<Product> vl=eService.getAllProducts();
//		return vl;
//	}
	
	@GetMapping
	public List<ProductResponse> getAllProducts(){
		return eService.getAllProducts();

	}

}
