package com.ryvas.project_web_services.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderItem {

    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem(Integer quantity, Double price, Product product) {
        validate(quantity, price, product);
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    private void validate(Integer quantity, Double price, Product product) {
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantidade inválida");
        }
        if(price <= 0){
            throw new RuntimeException("Preço inválido");
        }
        if(product == null){
            throw new RuntimeException("Produto obrigatório");
        }
    }
    public Double getSubTotal(){
        return quantity * price;
    }
}
