package com.foodservice.user.infrastructure.persistence.impl;

import com.foodservice.user.domain.model.User;
import com.foodservice.user.domain.repository.UserRepository;
import com.foodservice.user.infrastructure.persistence.UserRepositoryH2;
import com.foodservice.user.infrastructure.persistence.entity.UserEntity;
import com.foodservice.user.infrastructure.persistence.mapper.UserEntityMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.foodservice.user.infrastructure.persistence.mapper.UserEntityMapper.mapToUser;
import static com.foodservice.user.infrastructure.persistence.mapper.UserEntityMapper.mapToUserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryH2 repositoryH2;

    public UserRepositoryImpl(UserRepositoryH2 repositoryH2) {
        this.repositoryH2 = repositoryH2;
    }

    @Override
    public UUID save(User user) {
        UserEntity savedUser = repositoryH2.save(mapToUserEntity(user));
        return savedUser.getId();
    }

    @Override
    public User findOne(UUID id) {
        return mapToUser(repositoryH2.getReferenceById(id));
    }

    @Override
    public List<User> find() {
        return repositoryH2.findAll().stream()
                .map(UserEntityMapper::mapToUser)
                .toList();
    }
}
