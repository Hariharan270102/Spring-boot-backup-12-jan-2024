package edu.springboot.ProductService.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Component
@Scope("prototype")
public class ProductResponse 
{
	private Integer productId;
	private String productName;
	private Double productPrice;
	private Integer productQuantity;

}
