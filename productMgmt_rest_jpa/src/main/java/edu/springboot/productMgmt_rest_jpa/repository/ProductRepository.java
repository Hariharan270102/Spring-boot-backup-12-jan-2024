package edu.springboot.productMgmt_rest_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.springboot.productMgmt_rest_jpa.model.Product;

//@RepositoryRestResource(collectionResourceRel ="product",path = "product" )
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value="select * from product where category=:?1 or pname=:?1",nativeQuery = true)
	List<Product> findByPname(String pname);

}
