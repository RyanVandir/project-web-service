package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.ProductMapper;
import com.ryvas.project_web_services.adapters.out.entity.CategoryEntity;
import com.ryvas.project_web_services.adapters.out.entity.ProductEntity;
import com.ryvas.project_web_services.adapters.out.repository.CategoryRepository;
import com.ryvas.project_web_services.adapters.out.repository.ProductRepository;
import com.ryvas.project_web_services.domain.exception.CategoryNotFoundException;
import com.ryvas.project_web_services.domain.exception.DatabaseException;
import com.ryvas.project_web_services.domain.exception.ProductNotFoundException;
import com.ryvas.project_web_services.domain.model.Product;
import com.ryvas.project_web_services.port.out.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServicePort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> findAll() {
        return productMapper.toModel(productRepository.findAll());
    }

    @Override
    public Optional<Product> findById(Integer id) {
        try {
            return productRepository.findById(id)
                    .map(productMapper::toModel);
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }

    @Override
    public Product created(Product product) {
        try {
            ProductEntity productEntity = productMapper.toEntity(product);

            Set<CategoryEntity> categories = productEntity.getCategories().stream()
                    .map(cat -> categoryRepository.findById(cat.getId())
                            .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada!")))
                    .collect(Collectors.toSet());
            productEntity.setCategories(categories);
            return productMapper.toModel(productRepository.save(productEntity));
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade ao salvar produto");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }

    @Override
    public Product updated(Integer id, Product product) {
        try {
            ProductEntity productEntity = productRepository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado!"));
            return productMapper.toModel(productRepository.save(productEntity));
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade ao atualizar produto");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }
}
