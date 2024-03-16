package com.foodservice.order.domain.repository;

import com.foodservice.order.domain.model.Order;
import com.foodservice.order.domain.model.OrderFilter;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    UUID save(final Order order);
    List<Order> findByFilter(final OrderFilter orderFilter);
    Order findOne(UUID id);
}
