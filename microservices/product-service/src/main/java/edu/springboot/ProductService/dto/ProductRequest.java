package edu.springboot.ProductService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductRequest
{
	private String productName;
	private Double productPrice;
	private Integer productQuantity;

}
