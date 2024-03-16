package com.foodservice.order.infrastructure.integration.notification;

import com.foodservice.order.domain.model.enums.StatusOrder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationOrderDTO implements Serializable {

    private UUID customerId;
    private UUID merchantId;
    private StatusOrder statusOrder;
    private LocalDateTime createAt;

    public NotificationOrderDTO(UUID customerId, UUID merchantId, StatusOrder statusOrder, LocalDateTime createAt) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.statusOrder = statusOrder;
        this.createAt = createAt;
    }

    public NotificationOrderDTO() {
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
