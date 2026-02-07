package com.ryvas.project_web_services.usecase;

import com.ryvas.project_web_services.domain.exception.CategoryNotFoundException;
import com.ryvas.project_web_services.domain.exception.ProductNotFoundException;
import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.domain.model.Product;
import com.ryvas.project_web_services.port.in.ProductUseCasePort;
import com.ryvas.project_web_services.port.out.CategoryServicePort;
import com.ryvas.project_web_services.port.out.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductUseCase implements ProductUseCasePort {

    private final ProductServicePort productServicePort;
    private final CategoryServicePort categoryServicePort;

    @Override
    public List<Product> findAll() {
        return productServicePort.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productServicePort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado!"));
    }

    @Override
    public Product created(Product product) {
        Set<Category> categories = product.getCategories()
                .stream()
                .map(category -> categoryServicePort.findById(category.getId())
                        .orElseThrow(() -> new CategoryNotFoundException("Nenhuma categoria encontrada!")))
                .collect(Collectors.toSet());
        product.setCategories(categories);
        return productServicePort.created(product);
    }

    @Override
    public Product updated(Integer id, Product product) {
        return productServicePort.updated(id, product);
    }
}
