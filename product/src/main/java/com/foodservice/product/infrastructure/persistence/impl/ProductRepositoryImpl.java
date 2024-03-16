package com.foodservice.product.infrastructure.persistence.impl;

import com.foodservice.product.domain.model.Product;
import com.foodservice.product.domain.repository.ProductRepository;
import com.foodservice.product.infrastructure.persistence.ProductRepositoryH2;
import com.foodservice.product.infrastructure.persistence.entity.ProductEntity;
import com.foodservice.product.infrastructure.persistence.mapper.ProductEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.foodservice.product.infrastructure.persistence.mapper.ProductEntityMapper.mapToProduct;
import static com.foodservice.product.infrastructure.persistence.mapper.ProductEntityMapper.mapToProductEntity;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryH2 productRepositoryH2;

    public ProductRepositoryImpl(ProductRepositoryH2 productRepositoryH2) {
        this.productRepositoryH2 = productRepositoryH2;
    }

    @Override
    public UUID save(final Product product) {
        ProductEntity savedProduct = productRepositoryH2.save(mapToProductEntity(product));
        return savedProduct.getId();
    }

    @Override
    public Product findOne(UUID id) {
        return mapToProduct(productRepositoryH2.getReferenceById(id));
    }

    @Override
    public List<Product> find() {
        return productRepositoryH2.findAll().stream()
                .map(ProductEntityMapper::mapToProduct)
                .toList();
    }
}
