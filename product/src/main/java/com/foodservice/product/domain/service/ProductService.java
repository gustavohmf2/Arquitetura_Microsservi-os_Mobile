package com.foodservice.product.domain.service;

import com.foodservice.product.domain.model.Product;
import com.foodservice.product.view.dto.RegisterProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    UUID register(Product product);
    Product findOne(UUID id);
    List<Product> find();
}
