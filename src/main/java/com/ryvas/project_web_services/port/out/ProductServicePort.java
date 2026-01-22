package com.ryvas.project_web_services.port.out;

import com.ryvas.project_web_services.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServicePort {

    List<Product> findAll();

    Optional<Product> findById(Integer id);
}
