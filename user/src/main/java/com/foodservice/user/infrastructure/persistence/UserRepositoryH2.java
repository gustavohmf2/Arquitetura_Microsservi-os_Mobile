package com.foodservice.user.infrastructure.persistence;


import com.foodservice.user.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryH2 extends JpaRepository<UserEntity, UUID> {
}
