package edu.capstone_project.QuotingProducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.QuotingProducts.model.Subscriptions;
import edu.capstone_project.QuotingProducts.service.QuotingProductService;

@RestController
@RequestMapping("/products")
public class QuotingProductFrontController {
	@Autowired
	QuotingProductService eService;
	
	@PostMapping
	public String addSubscription(@RequestBody Subscriptions subscription) {
		return eService.addSubscription(subscription);
	}

}
