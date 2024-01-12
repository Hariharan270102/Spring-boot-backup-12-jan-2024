package edu.springboot.ProductService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboot.ProductService.dto.ProductRequest;
import edu.springboot.ProductService.dto.ProductResponse;
import edu.springboot.ProductService.model.Product;
import edu.springboot.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  //spring creates anonymous class and creates an object for us 
public class ProductService 
{
	
	private final ProductRepository repo;
	
	@Autowired
	Product productPojo; 
	
	
//	ProductResponse productResponse;
	
	public void createNewProduct(ProductRequest productRequest) {
		
		productPojo.setProductName(productRequest.getProductName());
		productPojo.setProductPrice(productRequest.getProductPrice());
		productPojo.setProductQuantity(productRequest.getProductQuantity());
		
		repo.save(productPojo);
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
