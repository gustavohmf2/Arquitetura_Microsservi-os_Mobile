package com.foodservice.product.view;

import com.foodservice.product.domain.model.Product;
import com.foodservice.product.view.dto.RegisterProductDTO;

public final class ProductMapper {
    public static Product mapToProduct(final RegisterProductDTO registerProductDTO) {
        return new Product(registerProductDTO.name(), registerProductDTO.description(), registerProductDTO.price(), registerProductDTO.merchant());
    }
}
