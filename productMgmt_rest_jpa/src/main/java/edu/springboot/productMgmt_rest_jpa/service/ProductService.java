package edu.springboot.productMgmt_rest_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springboot.productMgmt_rest_jpa.model.Product;
import edu.springboot.productMgmt_rest_jpa.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;

	public Product addProductDB(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
		
	}

	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
		
	}

	public List<Product> viewAll() {
		// TODO Auto-generated method stub
		return (List<Product>) repo.findAll();
	}

	public Optional<Product> viewSingleProduct(int pid) {
		// TODO Auto-generated method stub
		return repo.findById(pid);
	}

	public String deleteProductDB(int pid) {
		// TODO Auto-generated method stub
		repo.deleteById(pid);
		return "product deleted";
	}

	public List<Product> searchProduct(String pname) {
		// TODO Auto-generated method stub
		return repo.findByPname(pname);
//		return null;
	}

}
