package edu.springboot.InventoryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.springboot.InventoryService.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> 
{
	List<Inventory> findByProductNameIn(List<String> productName);

}
