package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.domain.model.Product;
import com.ryvas.project_web_services.port.in.ProductUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCasePort productUseCasePort;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productUseCasePort.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(productUseCasePort.findById(id));
    }
}
