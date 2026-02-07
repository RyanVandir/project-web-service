package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.domain.model.Order;
import com.ryvas.project_web_services.port.in.OrderUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderUseCasePort orderUseCasePort;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderUseCasePort.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Order> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(orderUseCasePort.deleteById(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderUseCasePort.findById(id));
    }
}
