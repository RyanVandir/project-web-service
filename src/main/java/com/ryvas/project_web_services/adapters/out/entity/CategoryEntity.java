package com.ryvas.project_web_services.adapters.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "categories")
    Set<ProductEntity> products = new HashSet<>();

    public CategoryEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}