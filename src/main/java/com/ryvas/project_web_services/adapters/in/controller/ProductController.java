package com.ryvas.project_web_services.adapters.in.controller;

import com.ryvas.project_web_services.adapters.in.dto.ProductDto;
import com.ryvas.project_web_services.adapters.in.dto.ProductResponse;
import com.ryvas.project_web_services.adapters.mapper.ProductMapper;
import com.ryvas.project_web_services.port.in.ProductUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductUseCasePort productUseCasePort;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponse> created(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                productMapper.toResponse(
                        productUseCasePort.created(productMapper.toModel(productDto))
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.toResponse(productUseCasePort.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.toResponse(productUseCasePort.findById(id)));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> update(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                productMapper.toResponse(
                        productUseCasePort.updated(id, productMapper.toModel(productDto))
                )
        );
    }
}
