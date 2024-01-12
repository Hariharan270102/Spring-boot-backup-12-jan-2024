package edu.springboot.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.springboot.OrderService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
