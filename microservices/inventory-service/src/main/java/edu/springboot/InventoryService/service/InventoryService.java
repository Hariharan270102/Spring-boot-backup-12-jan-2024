package edu.springboot.InventoryService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboot.InventoryService.dto.InventoryRequestOriginal;
import edu.springboot.InventoryService.dto.InvetoryRequest;
import edu.springboot.InventoryService.model.Inventory;
import edu.springboot.InventoryService.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryService
{
	private final InventoryRepository repo;
	
	

	
	public List<InvetoryRequest> isInStock(List<String> productName){
		try {
			System.out.println("Thread started sleeping");

			Thread.sleep(30000);
			
			System.out.println("Thread is awake");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Inventory> il=repo.findByProductNameIn(productName);
		List<InvetoryRequest> irl=new ArrayList<>();
		for(Inventory i:il) {
			irl.add(mapToInventoryRequest(i));
		}
		return irl;
	}

	private InvetoryRequest mapToInventoryRequest(Inventory i) {
		InvetoryRequest irobj=InvetoryRequest.builder().productName(i.getProductName())
				.productQuantity(i.getProductQuantity()>0).build();
		
		// TODO Auto-generated method stub
		return irobj;
	}

	public String addToInventory(InventoryRequestOriginal invRequestOrg) {
		Inventory inventory=new Inventory();
		inventory.setProductName(invRequestOrg.getProductName());
		inventory.setProductQuantity(invRequestOrg.getProductQuantity());
		repo.save(inventory);
		return "PRODUCT ADDED TO INVENTORY SUCCESSFULLY!!!";
		// TODO Auto-generated method stub
		
	}
	


}
