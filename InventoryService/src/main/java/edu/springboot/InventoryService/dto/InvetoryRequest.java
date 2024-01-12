package edu.springboot.InventoryService.dto;

import edu.springboot.InventoryService.model.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvetoryRequest 
{
	private String productName;
	private Boolean productQuantity;

}
