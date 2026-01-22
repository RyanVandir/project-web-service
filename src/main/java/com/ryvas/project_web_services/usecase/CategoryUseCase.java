package com.ryvas.project_web_services.usecase;

import com.ryvas.project_web_services.domain.exception.CategoryNotFoundException;
import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.port.in.CategoryUseCasePort;
import com.ryvas.project_web_services.port.out.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryUseCase implements CategoryUseCasePort {

    private final CategoryServicePort categoryServicePort;

    @Override
    public List<Category> findAll() {
        return categoryServicePort.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryServicePort.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Nenhuma categoria encontrada!"));
    }

    @Override
    public Category findByName(String name) {
        return categoryServicePort.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException("Nenhuma categoria encontrada!"));

    }
}
