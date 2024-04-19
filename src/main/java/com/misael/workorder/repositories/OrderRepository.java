package com.misael.workorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misael.workorder.entities.Order;

/**
 * OrderRepository
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

    
}