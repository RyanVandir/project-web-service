package com.ryvas.project_web_services.adapters.out.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ryvas.project_web_services.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    @Setter(AccessLevel.NONE)
    List<OrderEntity> orders = new ArrayList<>();

    public UserEntity(Integer id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public void update(User user) {
        if (user.getName() != null && !user.getName().isBlank()) {
            this.name = user.getName();
        }
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            this.email = user.getEmail();
        }
        if (user.getPhone() != null && !user.getPhone().isBlank()) {
            this.phone = user.getPhone();
        }
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            this.password = user.getPassword();
        }
    }
}