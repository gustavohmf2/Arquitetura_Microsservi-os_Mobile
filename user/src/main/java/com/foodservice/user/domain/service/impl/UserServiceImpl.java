package com.foodservice.user.domain.service.impl;

import com.foodservice.user.domain.model.User;
import com.foodservice.user.domain.repository.UserRepository;
import com.foodservice.user.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record UserServiceImpl(UserRepository userRepository) implements UserService {
    @Override
    public UUID register(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(UUID id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> find() {
        return userRepository.find();
    }
}
