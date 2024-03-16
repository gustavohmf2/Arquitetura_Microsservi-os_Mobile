package com.foodservice.product.domain.service.impl;

import com.foodservice.product.domain.model.Product;
import com.foodservice.product.domain.repository.ProductRepository;
import com.foodservice.product.domain.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record ProductServiceImpl(ProductRepository productRepository) implements ProductService {
    @Override
    public UUID register(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findOne(UUID id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> find() {
        return productRepository.find();
    }
}
