package edu.capstone_project.QuotingProducts.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Component
@Entity
@Table(name = "t_products")
public class ProductPlans 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String planId;
	private String planName;
	private int planPrice;
	private String planValidity;
	private String planData;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Subscriptions> subscriptions;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Locations> location;
	private String planCategory;
	public ProductPlans(int productId, String planId, String planName, int planPrice, String planValidity,
			String planData, List<Subscriptions> subscriptions, List<Locations> location, String planCategory) {
		super();
		this.productId = productId;
		this.planId = planId;
		this.planName = planName;
		this.planPrice = planPrice;
		this.planValidity = planValidity;
		this.planData = planData;
		this.subscriptions = subscriptions;
		this.location = location;
		this.planCategory = planCategory;
	}
	public ProductPlans() {
		super();
	}
	
	

}
