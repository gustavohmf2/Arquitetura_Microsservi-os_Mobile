package com.foodservice.order.infrastructure.restclient.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@FeignClient("product-service")
public interface ProductClient {
    @RequestMapping("/products")
    ResponseEntity getUserProduct(@PathVariable("id") UUID id);
}
