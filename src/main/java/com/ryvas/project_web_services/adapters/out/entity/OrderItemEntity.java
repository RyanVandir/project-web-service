package com.ryvas.project_web_services.adapters.out.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ryvas.project_web_services.adapters.out.entity.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_ordem_item")
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItemEntity(OrderEntity orderEntity, ProductEntity productEntity, Integer quantity, Double price) {
        id.setOrderEntity(orderEntity);
        id.setProductEntity(productEntity);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public OrderEntity getOrder(){
        return id.getOrderEntity();
    }
    @JsonIgnore
    public ProductEntity getProduct(){
        return id.getProductEntity();
    }
}
