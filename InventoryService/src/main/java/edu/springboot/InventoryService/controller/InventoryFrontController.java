package edu.springboot.InventoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.InventoryService.dto.InvetoryRequest;
import edu.springboot.InventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryFrontController 
{
	@Autowired
	InventoryService eService;
	
	@GetMapping
	public List<InvetoryRequest> isInStock(@RequestBody List<String> name){
//		return 
		return eService.isInStock(name);
		
	}

}
