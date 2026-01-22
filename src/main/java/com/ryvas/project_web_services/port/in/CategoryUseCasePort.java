package com.ryvas.project_web_services.port.in;

import com.ryvas.project_web_services.domain.model.Category;

import java.util.List;

public interface CategoryUseCasePort {

    List<Category> findAll();

    Category findById(Integer id);

    Category findByName(String name);
}
