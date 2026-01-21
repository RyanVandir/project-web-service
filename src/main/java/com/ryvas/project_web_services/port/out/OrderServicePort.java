package com.ryvas.project_web_services.port.out;

import com.ryvas.project_web_services.domain.model.Order;
import com.ryvas.project_web_services.domain.model.User;

import java.util.List;

public interface OrderServicePort {

    List<Order> findAll();

    Order deleteById(Integer id);

    Order findById(Integer id);
}
