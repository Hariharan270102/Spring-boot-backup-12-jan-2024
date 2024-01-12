package edu.capstone_project.QuotingProducts.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.capstone_project.QuotingProducts.model.Subscriptions;
import edu.capstone_project.QuotingProducts.repository.SubscriptionsRepository;

public class QuotingProductService {
	@Autowired
	SubscriptionsRepository subRepo;

	public String addSubscription(Subscriptions subscription) {
		// TODO Auto-generated method stub
		System.out.println(1);
		subRepo.save(subscription);
		
		return "subscription added successfully";
	}

}
