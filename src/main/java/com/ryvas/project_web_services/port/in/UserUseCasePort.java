package com.ryvas.project_web_services.port.in;

import com.ryvas.project_web_services.domain.model.User;

import java.util.List;

public interface UserUseCasePort {

    List<User> findAll();
}
