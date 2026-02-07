package com.ryvas.project_web_services.port.out;

import com.ryvas.project_web_services.domain.model.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryServicePort {

    Set<Category> findAll();

    Optional<Category> findById(Integer id);

    Category created(Category category);
}
