package com.foodservice.order.domain.service;

import com.foodservice.order.domain.model.Order;
import com.foodservice.order.domain.model.OrderFilter;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    UUID newOrder(final Order order);

    List<Order> findFiltered(final OrderFilter orderFilter);

    Order findOne(UUID id);
}
