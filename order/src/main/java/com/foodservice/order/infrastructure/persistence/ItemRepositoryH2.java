package com.foodservice.order.infrastructure.persistence;

import com.foodservice.order.infrastructure.persistence.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepositoryH2 extends JpaRepository<ItemEntity, UUID> {
}
