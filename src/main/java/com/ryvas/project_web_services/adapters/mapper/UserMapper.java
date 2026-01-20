package com.ryvas.project_web_services.adapters.mapper;

import com.ryvas.project_web_services.adapters.out.entity.UserEntity;
import com.ryvas.project_web_services.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // Domain -> Entity
    List<UserEntity> toEntity(List<User> users);
    UserEntity toEntity(User user);

    // Entity -> Domain
    List<User> toModel(List<UserEntity> userEntities);
    User toModel(UserEntity userEntity);
}
