package com.ryvas.project_web_services.adapters.mapper;

import com.ryvas.project_web_services.adapters.in.dto.CategoryResponse;
import com.ryvas.project_web_services.adapters.out.entity.CategoryEntity;
import com.ryvas.project_web_services.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    // API -> DOMAIN
    Category toModel(CategoryResponse categoryResponse);

    CategoryResponse toResponse(Category category);

    Set<CategoryResponse> toResponse(Set<Category> categories);

    // Domain -> Entity
    Set<CategoryEntity> toEntity(Set<Category> categories);

    CategoryEntity toEntity(Category category);

    // Entity -> Domain
    Set<Category> toModel(List<CategoryEntity> categoryEntities);

    Category toModel(CategoryEntity categoryEntity);

}
