package com.ryvas.project_web_services.adapters.mapper;

import com.ryvas.project_web_services.adapters.out.entity.OrderEntity;
import com.ryvas.project_web_services.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    // Domain -> Entity
    List<OrderEntity> toEntity(List<Order> orders);

    OrderEntity toEntity(Order order);

    // Entity -> Domain
    List<Order> toModel(List<OrderEntity> orderEntities);

    Order toModel(OrderEntity orderEntity);

}
