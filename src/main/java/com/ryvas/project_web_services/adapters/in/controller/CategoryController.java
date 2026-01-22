package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.port.in.CategoryUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCasePort categoryUseCasePort;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok().body(categoryUseCasePort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoryUseCasePort.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(categoryUseCasePort.findByName(name));
    }
}
