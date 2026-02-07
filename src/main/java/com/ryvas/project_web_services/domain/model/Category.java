package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.exception.InvalidCategoryException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Category {

    private Integer id;
    private String name;

    Category(Integer id) {
        this.id = id;
    }

    public static Category reference(Integer id) {
        return new Category(id);
    }

    public Category(Integer id, String name) {
        validate(name);
        this.id = id;
        this.name = name;
    }

    public static Category create(Integer id, String name) {
        return new Category(id, name);
    }

    private void validate(String name) {
        if (name == null || name.isBlank() && name.length() < 3) {
            throw new InvalidCategoryException("Categoria deve possuir um nome de no minimo 3 caracteres");
        }
    }
}