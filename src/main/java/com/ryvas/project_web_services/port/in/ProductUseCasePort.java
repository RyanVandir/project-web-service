package com.ryvas.project_web_services.port.in;

import com.ryvas.project_web_services.domain.model.Product;

import java.util.List;

public interface ProductUseCasePort {

    List<Product> findAll();

    Product findById(Integer id);

    Product created(Product product);

    Product updated(Integer id, Product product);
}
