package com.foodservice.user.infrastructure.persistence.mapper;

import com.foodservice.user.domain.model.User;
import com.foodservice.user.infrastructure.persistence.entity.UserEntity;

public final class UserEntityMapper {

    public static UserEntity mapToUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setRegisterNumber(user.registerNumber());
        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        userEntity.setPhone(user.phone());
        userEntity.setAddress(user.address());
        return userEntity;
    }

    public static User mapToUser(final UserEntity userEntity) {
        return new User(userEntity.getRegisterNumber(),userEntity.getName(), userEntity.getEmail(), userEntity.getPhone(), userEntity.getAddress());
    }
}
