package com.foodservice.order.domain.model;

import com.foodservice.order.domain.model.enums.StatusOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID customerId;
    private UUID merchantId;
    private StatusOrder statusOrder;
    private List<Item> items;

    private LocalDateTime createAt;

    public Order(UUID customerId, UUID merchantId, StatusOrder statusOrder, List<Item> items) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.statusOrder = statusOrder;
        this.items = items;
    }

    public Order(UUID customerId, UUID merchantId, StatusOrder statusOrder) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.statusOrder = statusOrder;
    }

    public Order() {
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(UUID merchantId) {
        this.merchantId = merchantId;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
