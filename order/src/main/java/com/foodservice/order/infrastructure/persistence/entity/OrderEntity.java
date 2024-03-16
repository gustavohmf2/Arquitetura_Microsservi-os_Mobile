package com.foodservice.order.infrastructure.persistence.entity;

import com.foodservice.order.domain.model.enums.StatusOrder;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private UUID customerId;
    private UUID merchantId;
    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemEntity> items;
    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime localDateTime;

    public OrderEntity(UUID customerId, UUID merchantId, StatusOrder statusOrder) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.statusOrder = statusOrder;
        this.items = items;
    }

    public OrderEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
