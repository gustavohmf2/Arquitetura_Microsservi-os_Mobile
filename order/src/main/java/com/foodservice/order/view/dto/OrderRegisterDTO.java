package com.foodservice.order.view.dto;

import com.foodservice.order.domain.model.Item;

import java.util.List;
import java.util.UUID;

public class OrderRegisterDTO {
    private UUID customerId;
    private UUID restaurantId;
    private List<Item> items;

    public OrderRegisterDTO(UUID customerId, UUID restaurantId, List<Item> items) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.items = items;
    }

    public OrderRegisterDTO() {
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
