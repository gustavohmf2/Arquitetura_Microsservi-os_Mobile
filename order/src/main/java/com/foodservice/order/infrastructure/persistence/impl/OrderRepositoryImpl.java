package com.foodservice.order.infrastructure.persistence.impl;

import com.foodservice.order.domain.model.Order;
import com.foodservice.order.domain.model.OrderFilter;
import com.foodservice.order.domain.repository.OrderRepository;
import com.foodservice.order.infrastructure.persistence.ItemRepositoryH2;
import com.foodservice.order.infrastructure.persistence.OrderRepositoryH2;
import com.foodservice.order.infrastructure.persistence.entity.OrderEntity;
import com.foodservice.order.infrastructure.persistence.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static com.foodservice.order.infrastructure.persistence.mapper.OrderMapper.mapToOrder;
import static com.foodservice.order.infrastructure.persistence.mapper.OrderMapper.mapToOrderEntity;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderRepositoryH2 orderRepositoryH2;
    private final ItemRepositoryH2 itemRepositoryH2;

    public OrderRepositoryImpl(OrderRepositoryH2 orderRepositoryH2, ItemRepositoryH2 itemRepositoryH2) {
        this.orderRepositoryH2 = orderRepositoryH2;
        this.itemRepositoryH2 = itemRepositoryH2;
    }

    @Override
    public UUID save(final Order order) {
        final OrderEntity savedOrder = orderRepositoryH2.save(mapToOrderEntity(order));
        return savedOrder.getId();
    }

    @Override
    public List<Order> findByFilter(OrderFilter orderFilter) {
        return orderRepositoryH2.findByFilter(orderFilter.customerId(), orderFilter.merchantId(), orderFilter.statusOrder())
                .stream()
                .map(OrderMapper::mapToOrder)
                .toList();
    }

    @Override
    public Order findOne(UUID id) {
        return mapToOrder(orderRepositoryH2.findById(id).orElseThrow(() -> new RuntimeException("Order not found")));
    }

}
