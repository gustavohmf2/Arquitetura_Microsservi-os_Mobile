package com.foodservice.order.infrastructure.persistence.mapper;

import com.foodservice.order.domain.model.Item;
import com.foodservice.order.domain.model.Order;
import com.foodservice.order.infrastructure.persistence.entity.ItemEntity;
import com.foodservice.order.infrastructure.persistence.entity.OrderEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;

public final class OrderMapper {

    public static Order mapToOrder(final OrderEntity orderEntity) {
        var order = new Order(orderEntity.getCustomerId(), orderEntity.getMerchantId(), orderEntity.getStatusOrder());
        order.setCreateAt(orderEntity.getLocalDateTime());
        return order;
    }

    private static List<Item> mapToItem(List<ItemEntity> items) {
        return items.stream().map(itemEntity -> new Item(itemEntity.getProductId(), itemEntity.getQuantity(), itemEntity.getUnitPrice())).toList();
    }


    public static OrderEntity mapToOrderEntity(final Order order) {
        return new OrderEntity(order.getCustomerId(), order.getMerchantId(), order.getStatusOrder());
    }

    private static List<ItemEntity> mapToItemEntity(List<Item> items) {
        return items.stream().map(item -> new ItemEntity(item.getProductId(), item.getQuantity(), item.getUnitPrice())).toList();
    }
}
