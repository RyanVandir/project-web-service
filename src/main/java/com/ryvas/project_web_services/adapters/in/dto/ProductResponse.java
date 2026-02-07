package com.ryvas.project_web_services.adapters.in.dto;

import java.util.Set;

public record ProductResponse(Integer id, String name, String description, Double price, String imgUrl,
                              Set<CategoryResponse> categories) {
}
