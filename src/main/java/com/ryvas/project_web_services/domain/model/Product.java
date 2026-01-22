package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.exception.InvalidProductException;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class Product {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    private Set<Category> categories;

    public Product(Integer id, String name, String description, Double price, String imgUrl,  Set<Category> categories) {
        validate(name, description, price, imgUrl, categories);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = Set.copyOf(categories); // imutável
    }

    private void validate(String name, String description, Double price,  String imgUrl,  Set<Category> categories) {
        if (name == null || name.isBlank()) {
            throw new InvalidProductException("Produto precisa possuir um nome");
        }
        if (description == null || description.isEmpty()) {
            throw new InvalidProductException("Produto necessita de descrição");
        }
        if (price == null || price <= 0) {
            throw new InvalidProductException("Produto precisa possuir um valor");
        }
        if (categories == null || categories.isEmpty()) {
            throw new InvalidProductException("Produto precisa possuir ao menos uma categoria");
        }
    }
}
