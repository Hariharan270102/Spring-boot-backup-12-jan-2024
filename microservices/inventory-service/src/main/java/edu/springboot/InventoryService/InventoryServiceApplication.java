package edu.springboot.InventoryService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import edu.springboot.InventoryService.model.Inventory;
import edu.springboot.InventoryService.repository.InventoryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {
//	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args->{
			Inventory phone=Inventory.builder().build();
			phone.setProductName("Iphone 15");
			phone.setProductQuantity(100);
			inventoryRepository.save(phone);
			
//			phone.setProductName("Iphone 14");
//			phone.setProductQuantity(50);
//			inventoryRepository.save(phone);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
