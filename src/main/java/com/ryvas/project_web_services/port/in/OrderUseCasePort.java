package com.ryvas.project_web_services.port.in;

import com.ryvas.project_web_services.domain.model.Order;

import java.util.List;

public interface OrderUseCasePort {

    List<Order> findAll();

    Order deleteById(Integer id);

    Order findById(Integer id);
}
