package com.ryvas.project_web_services.adapters.mapper;

import com.ryvas.project_web_services.adapters.in.dto.ProductDto;
import com.ryvas.project_web_services.adapters.in.dto.ProductResponse;
import com.ryvas.project_web_services.adapters.out.entity.ProductEntity;
import com.ryvas.project_web_services.domain.model.Category;
import com.ryvas.project_web_services.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    // API -> DOMAIN
    @Mapping(target = "categories",
            source = "categoriesId",
            qualifiedByName = "mapCategories")
    Product toModel(ProductDto productDto);

    @Named("mapCategories")
    default Set<Category> mapCategories(Set<Integer> ids) {
        if (ids == null) return Set.of();
        return ids.stream()
                .map(Category::reference)
                .collect(Collectors.toSet());
    }

    // DOMAIN -> API
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponse(List<Product> products);

    // Domain -> Entity
    List<ProductEntity> toEntity(List<Product> products);

    ProductEntity toEntity(Product product);

    // Entity -> Domain
    List<Product> toModel(List<ProductEntity> productEntities);

    Product toModel(ProductEntity productEntity);

}
