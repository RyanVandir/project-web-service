package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.port.in.CategoryUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCasePort categoryUseCasePort;

    @GetMapping
    public ResponseEntity<Set<Category>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryUseCasePort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryUseCasePort.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryUseCasePort.findByName(name));
    }
}
