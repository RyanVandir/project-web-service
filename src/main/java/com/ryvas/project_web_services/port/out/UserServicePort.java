package com.ryvas.project_web_services.port.out;

import com.ryvas.project_web_services.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServicePort {

    List<User> findAll();

    User deleteById(Integer id);

    Optional<User> findById(Integer id);

    User insert(User user);

    User update(Integer id, User user);
}
