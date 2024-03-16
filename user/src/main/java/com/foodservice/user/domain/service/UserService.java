package com.foodservice.user.domain.service;

import com.foodservice.user.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public UUID register(final User user);
    public User findOne(final UUID id);
    public List<User> find();
}
