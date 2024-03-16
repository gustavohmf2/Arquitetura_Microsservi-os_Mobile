package com.foodservice.order.infrastructure.persistence;

import com.foodservice.order.domain.model.Order;
import com.foodservice.order.domain.model.enums.StatusOrder;
import com.foodservice.order.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepositoryH2 extends JpaRepository<OrderEntity, UUID> {
    @Query("SELECT o FROM order o WHERE o.customerId = :customerId or o.merchantId = :merchantId or o.statusOrder = :statusOrder")
    List<OrderEntity> findByFilter(UUID customerId, UUID merchantId, StatusOrder statusOrder);
}
