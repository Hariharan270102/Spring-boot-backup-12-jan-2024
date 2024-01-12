package edu.springboot.OrderService.dto;

import edu.springboot.OrderService.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItemsDto
{
	private Integer id;
	private String productName;
	private Double productPrice;
	private Integer productQuantity;

}
