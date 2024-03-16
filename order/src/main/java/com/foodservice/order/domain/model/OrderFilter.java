package com.foodservice.order.domain.model;

import com.foodservice.order.domain.model.enums.StatusOrder;

import java.util.UUID;

public record OrderFilter(
        UUID customerId,
        UUID merchantId,
        StatusOrder statusOrder) {
}
