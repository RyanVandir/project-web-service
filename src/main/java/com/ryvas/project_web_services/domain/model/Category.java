package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.exception.InvalidCategoryException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Category {

    Integer id;
    String name;

    public Category(Integer id, String name) {
        validate(name);
        this.id = id;
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank() && name.length() < 3) {
            throw new InvalidCategoryException("Categoria deve possuir um nome de no minimo 3 caracteres");
        }
    }
}