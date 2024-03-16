package com.foodservice.product.domain.repository;

import com.foodservice.product.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    UUID save(Product product);

    Product findOne(UUID id);

    List<Product> find();
}
