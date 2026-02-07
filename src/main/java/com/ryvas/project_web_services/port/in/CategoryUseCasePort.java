package com.ryvas.project_web_services.port.in;

import com.ryvas.project_web_services.domain.model.Category;

import java.util.Set;

public interface CategoryUseCasePort {

    Set<Category> findAll();

    Category findById(Integer id);

    Category created(Category category);
}
