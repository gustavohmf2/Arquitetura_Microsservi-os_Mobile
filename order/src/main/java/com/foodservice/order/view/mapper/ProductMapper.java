package com.foodservice.order.view.mapper;

import com.foodservice.order.domain.model.Order;
import com.foodservice.order.view.dto.OrderRegisterDTO;

public final class ProductMapper {
    public static Order mapToOrder(final OrderRegisterDTO orderRegisterDTO) {
        var order = new Order();
        order.setCustomerId(orderRegisterDTO.getCustomerId());
        order.setMerchantId(orderRegisterDTO.getRestaurantId());
        order.setItems(orderRegisterDTO.getItems());
        return order;
    }
}
