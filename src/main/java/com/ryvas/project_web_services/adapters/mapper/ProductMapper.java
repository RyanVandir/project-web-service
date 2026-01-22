package com.ryvas.project_web_services.adapters.mapper;

import com.ryvas.project_web_services.adapters.out.entity.ProductEntity;
import com.ryvas.project_web_services.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    // Domain -> Entity
    List<ProductEntity> toEntity(List<Product> products);

    ProductEntity toEntity(Product product);

    // Entity -> Domain
    List<Product> toModel(List<ProductEntity> productEntities);

    Product toModel(ProductEntity productEntity);

}
