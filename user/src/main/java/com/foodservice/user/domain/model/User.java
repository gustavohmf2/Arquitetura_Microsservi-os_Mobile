package com.foodservice.user.domain.model;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

public record User (

        String registerNumber,
        String name,
        String email,
        String phone,
        Address address) {
}
