package edu.springboot.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.springboot.ProductService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
