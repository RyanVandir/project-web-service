package com.ryvas.project_web_services.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Category {

    Integer id;
    String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}