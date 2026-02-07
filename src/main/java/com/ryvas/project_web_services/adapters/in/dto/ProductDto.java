package com.ryvas.project_web_services.adapters.in.dto;

import java.util.Set;

public record ProductDto(String name, String description, Double price, String imgUrl, Set<Integer> categoriesId) {
}
