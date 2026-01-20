package com.ryvas.project_web_services.domain.model;

import com.ryvas.project_web_services.domain.exception.InvalidUserException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(Integer id, String name, String email, String phone, String password) {
        validate(name, email, phone, password);
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    private void validate(String name, String email, String phone, String password) {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserException("Nome obrigatório!");
        }
        if (name.trim().length() < 3) {
            throw new InvalidUserException("Nome deve conter no mínimo 3 caracteres!");
        }
        if (email == null || email.isEmpty()) {
            throw new InvalidUserException("Email obrigatório!");
        }
        if (phone == null || phone.isEmpty()) {
            throw new InvalidUserException("Telefone obrigatório!");
        }
        if (phone.trim().length() < 8 || phone.trim().length() > 12) {
            throw new InvalidUserException("Número de telefone inválido!");
        }
        if (password == null || password.isEmpty()) {
            throw new InvalidUserException("Senha obrigatória!");
        }
    }
}
