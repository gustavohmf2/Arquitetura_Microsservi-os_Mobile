package com.foodservice.product.infrastructure.persistence.mapper;

import com.foodservice.product.domain.model.Product;
import com.foodservice.product.infrastructure.persistence.entity.ProductEntity;

public final class ProductEntityMapper {
    public static ProductEntity mapToProductEntity(final Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setMerchant(product.getMerchant());
        return productEntity;
    }

    public static Product mapToProduct(final ProductEntity productEntity) {
        return new Product(productEntity.getName(), productEntity.getDescription(), productEntity.getPrice(), productEntity.getMerchant());
    }

}
