package com.foodservice.order.infrastructure.restclient.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@FeignClient("user-service")
public interface UserClient {

    @RequestMapping("/users")
    ResponseEntity getUser(@PathVariable("id") UUID id);
}
