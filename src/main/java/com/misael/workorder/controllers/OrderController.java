package com.misael.workorder.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misael.workorder.entities.Order;
import com.misael.workorder.entities.dtos.OrderRequestDto;
import com.misael.workorder.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

/**
 * OrderController
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @Operation(summary = "Realiza criação de ordem de serviço, insira nome do Cliente, Titulo e Descrição. Caso o cliente esteja cadastrado a api externa irá permitir a criação da ordem de serviço.")
    @PostMapping
    public ResponseEntity<Order> saveOrder(@Valid @RequestBody OrderRequestDto dto){
        Order order = service.saveOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @Operation(summary = "Realiza listagem de todas as ordem de serviço cadastradas.")
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @Operation(summary = "Realiza a procura de uma ordem de serviço pela número de ID.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable(value = "id") Integer id){
        Order order = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
    
}