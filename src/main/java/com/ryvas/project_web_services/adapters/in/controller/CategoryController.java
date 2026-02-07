package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.adapters.in.dto.CategoryResponse;
import com.ryvas.project_web_services.adapters.mapper.CategoryMapper;
import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.port.in.CategoryUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCasePort categoryUseCasePort;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<Set<CategoryResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                categoryMapper.toResponse(categoryUseCasePort.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                categoryMapper.toResponse(categoryUseCasePort.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> created(@RequestBody CategoryResponse categoryResponse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                categoryMapper.toResponse(
                        categoryUseCasePort.created(categoryMapper.toModel(categoryResponse))
                )
        );
    }
}
