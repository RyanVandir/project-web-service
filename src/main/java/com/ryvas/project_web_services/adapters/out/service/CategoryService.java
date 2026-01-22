package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.CategoryMapper;
import com.ryvas.project_web_services.adapters.out.entity.CategoryEntity;
import com.ryvas.project_web_services.adapters.out.repository.CategoryRepository;
import com.ryvas.project_web_services.domain.exception.CategoryNotFoundException;
import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.port.out.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements CategoryServicePort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public List<Category> findAll() {
        return categoryMapper.toModel(categoryRepository.findAll());
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toModel);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name)
                .map(categoryMapper::toModel);
    }
}
