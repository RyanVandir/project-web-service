package com.ryvas.project_web_services.usecase;

import com.ryvas.project_web_services.domain.exception.ProductNotFoundException;
import com.ryvas.project_web_services.domain.model.Product;
import com.ryvas.project_web_services.port.in.ProductUseCasePort;
import com.ryvas.project_web_services.port.out.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductUseCase implements ProductUseCasePort {

    private final ProductServicePort productServicePort;

    @Override
    public List<Product> findAll() {
        return productServicePort.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productServicePort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado!"));
    }
}
