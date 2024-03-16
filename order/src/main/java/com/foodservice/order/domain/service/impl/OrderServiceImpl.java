package com.foodservice.order.domain.service.impl;

import com.foodservice.order.domain.events.CreateOrderEvent;
import com.foodservice.order.domain.events.OrderPaymentEvent;
import com.foodservice.order.domain.model.Order;
import com.foodservice.order.domain.model.OrderFilter;
import com.foodservice.order.domain.model.OrderPaymentStatus;
import com.foodservice.order.domain.model.enums.StatusOrder;
import com.foodservice.order.domain.repository.OrderRepository;
import com.foodservice.order.domain.service.OrderService;
import com.foodservice.order.infrastructure.restclient.product.ProductClient;
import com.foodservice.order.infrastructure.restclient.user.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    private final ProductClient productClient;

    private final UserClient userClient;

    public OrderServiceImpl(OrderRepository orderRepository, ApplicationEventPublisher applicationEventPublisher, ProductClient productClient, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.productClient = productClient;
        this.userClient = userClient;
    }

    @Override
    public UUID newOrder(final Order order) {
        logger.info("m=newOrder, status=start, register new order");
        validate(order);
        order.setStatusOrder(StatusOrder.OPEN);
        UUID orderId = orderRepository.save(order);
        applicationEventPublisher.publishEvent(new CreateOrderEvent(this, orderId));
        logger.info("m=newOrder, status=finish, register new order");
        return orderId;
    }

    @Override
    public List<Order> findFiltered(OrderFilter orderFilter) {
        return orderRepository.findByFilter(orderFilter);
    }

    @Override
    public Order findOne(UUID id) {
        return orderRepository.findOne(id);
    }

    @EventListener
    void paymentOrderProccess(OrderPaymentEvent event) {

        OrderPaymentStatus orderPaymentStatus = event.getOrderPaymentStatus();
        Order order = orderRepository.findOne(orderPaymentStatus.getOrderId());
        logger.info("m=paymentOrderProccess, status=start, receive payment process, statusOrder={}", order.getStatusOrder());
        switch (orderPaymentStatus.getPaymentStatus()) {
            case "PROCESSING":
                order.setStatusOrder(StatusOrder.WAITING_PAYMENT);
                break;
            case "APPROVED":
                order.setStatusOrder(StatusOrder.TO_DELIVERY);
                break;
            case "REJECTED":
                order.setStatusOrder(StatusOrder.PAYMENT_REFUSE);
                break;
            default:
                new RuntimeException("Payment status not recognized");
                break;
        }
        orderRepository.save(order);
        logger.info("m=paymentOrderProccess, status=finish, receive payment process, statusOrder={}", order.getStatusOrder());
    }


    private void validate(Order order) {
        logger.info("m=validate order, status=start, validar customer and merchant");
        ResponseEntity userResponse = userClient.getUser(order.getCustomerId());
        if(!userResponse.getStatusCode().is2xxSuccessful()) throw new RuntimeException("Usuario invalido");
        logger.info("customer={}, response={}", order.getCustomerId(), userResponse.getStatusCode());
        ResponseEntity merchatnResponse = userClient.getUser(order.getMerchantId());
        if(!merchatnResponse.getStatusCode().is2xxSuccessful()) throw new RuntimeException("Usuario invalido");
        logger.info("merchant={}, response={}", order.getMerchantId(), merchatnResponse.getStatusCode());
        logger.info("m=validate order, status=start, validar customer and merchant");
    }
}
