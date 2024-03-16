package com.foodservice.product.infrastructure.persistence;

import com.foodservice.product.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepositoryH2 extends JpaRepository<ProductEntity, UUID> {
}
