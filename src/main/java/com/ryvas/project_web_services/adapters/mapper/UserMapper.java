package com.ryvas.project_web_services.adapters.mapper;

import com.ryvas.project_web_services.adapters.in.dto.UserDto;
import com.ryvas.project_web_services.adapters.in.dto.UserResponse;
import com.ryvas.project_web_services.adapters.out.entity.UserEntity;
import com.ryvas.project_web_services.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    // API (Created) -> Domain
    User toModel(UserDto userDto);

    // Domain -> API RESPONSE
    List<UserResponse> toResponse(List<User> users);
    UserResponse toResponse(User user);

    // Domain -> Entity
    List<UserEntity> toEntity(List<User> users);
    UserEntity toEntity(User user);

    // Entity -> Domain
    List<User> toModel(List<UserEntity> userEntities);
    User toModel(UserEntity userEntity);
}
