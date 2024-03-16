package com.foodservice.user.view.mapper;

import com.foodservice.user.domain.model.Address;
import com.foodservice.user.domain.model.User;
import com.foodservice.user.view.dto.UserRegisterDTO;

public final class UserMapper {
    public static User mapToUser(final UserRegisterDTO userDTO) {
        final var address = new Address(userDTO.state(), userDTO.city(), userDTO.neighborhood(), userDTO.number());
        return new User(userDTO.registerNumber(),userDTO.name(), userDTO.email(), userDTO.phone(), address);
    }
}
