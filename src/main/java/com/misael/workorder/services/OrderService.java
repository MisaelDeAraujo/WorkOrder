package com.misael.workorder.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.misael.workorder.entities.Order;
import com.misael.workorder.entities.dtos.OrderRequestDto;
import com.misael.workorder.exceptions.UnregisteredUserException;
import com.misael.workorder.repositories.OrderRepository;

/**
 * OrderService
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ValidateCustomerRegistrationService validateCustomer;

    public Order saveOrder(OrderRequestDto dto){

        if(validateCustomer.validate(dto.ClientName())){
           Order order = Order.builder()
            .title(dto.title())
            .description(dto.description())
            .localDateTime(LocalDateTime.now())
            .build();
            repository.save(order);

            return order;

        }else{
            throw new UnregisteredUserException("Usuário não cadastrado");
        }

    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Integer id){
        Optional<Order> findOrderById = repository.findById(id);

        if(findOrderById.isEmpty()){
            throw new RuntimeException();
        }else{
            Order order = findOrderById.get();
            return order;
        }

    }
}