package edu.capstone_project.QuotingProducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.capstone_project.QuotingProducts.model.ProductPlans;

public interface PlansRepository extends JpaRepository<ProductPlans, Integer> {

}
