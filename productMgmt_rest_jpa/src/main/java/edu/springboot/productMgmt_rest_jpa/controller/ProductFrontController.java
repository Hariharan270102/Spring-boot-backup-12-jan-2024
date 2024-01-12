package edu.springboot.productMgmt_rest_jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.springboot.productMgmt_rest_jpa.model.Product;
import edu.springboot.productMgmt_rest_jpa.service.ProductService;

@RestController
public class ProductFrontController {
	
	@Autowired
	ProductService eService;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/")
	@ResponseBody
	public String homepage() {
		return "Welcome to product management system!!!";
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/addProduct")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		return eService.addProductDB(product);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/editProduct")
	@ResponseBody
	public Product editProduct(@RequestBody Product product) {
		return eService.updateProduct(product);
		
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/product")
	@ResponseBody
	public List<Product> viewProducts() {
		return eService.viewAll();
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/product/{pid}")
	@ResponseBody
	public Optional<Product> viewProduct(@PathVariable("pid")int pid) {
		return eService.viewSingleProduct(pid);
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/deleteProduct/{pid}")
	@ResponseBody
	public String deleteProduct(@PathVariable("pid") int pid) {
		return eService.deleteProductDB(pid);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/searchProduct/{pname}")
	@ResponseBody
	public List<Product> searchProduct(@PathVariable("pname")String pname) {
		return eService.searchProduct(pname);
//		return null;
		
		
		
	}
	
	
	
	

}
