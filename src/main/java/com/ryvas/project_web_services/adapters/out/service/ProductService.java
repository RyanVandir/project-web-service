package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.ProductMapper;
import com.ryvas.project_web_services.adapters.out.repository.ProductRepository;
import com.ryvas.project_web_services.domain.model.Product;
import com.ryvas.project_web_services.port.out.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServicePort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.toModel(productRepository.findAll());
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toModel);
    }
}
