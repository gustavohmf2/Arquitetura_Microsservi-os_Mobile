package com.foodservice.user.domain.repository;

import com.foodservice.user.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    UUID save(User user);

    User findOne(UUID id);

    List<User> find();
}
