package edu.springboot.OrderService.dto;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest 
{	
	private List<OrderLineItemsDto> orderLineItemsDto;

}

