package com.ryvas.project_web_services.port.out;

import com.ryvas.project_web_services.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryServicePort {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    Optional<Category> findByName(String name);
}
