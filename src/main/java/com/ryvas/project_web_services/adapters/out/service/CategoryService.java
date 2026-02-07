package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.CategoryMapper;
import com.ryvas.project_web_services.adapters.out.repository.CategoryRepository;
import com.ryvas.project_web_services.domain.exception.DatabaseException;
import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.port.out.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CategoryService implements CategoryServicePort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public Set<Category> findAll() {
        return categoryMapper.toModel(categoryRepository.findAll());
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toModel);
    }

    @Override
    public Category created(Category category) {
        try {
        return categoryMapper.toModel(categoryRepository.save(categoryMapper.toEntity(category)));
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade ao criar categoria");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }
}
