package com.ryvas.project_web_services.port.out;

import com.ryvas.project_web_services.domain.model.User;

import java.util.List;

public interface UserServicePort {

    List<User> findAll();

    User deleteById(Integer id);
}
