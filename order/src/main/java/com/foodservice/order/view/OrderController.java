package com.foodservice.order.view;

import com.foodservice.order.domain.model.OrderFilter;
import com.foodservice.order.domain.model.enums.StatusOrder;
import com.foodservice.order.domain.service.OrderService;
import com.foodservice.order.view.dto.OrderRegisterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.foodservice.order.view.mapper.ProductMapper.mapToOrder;

@RestController
@RequestMapping("/orders")
public record OrderController(OrderService orderService) {

    @PostMapping
    ResponseEntity register(@RequestBody OrderRegisterDTO orderRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.newOrder(mapToOrder(orderRegisterDTO)));
    }

    @GetMapping
    ResponseEntity findFiltered(@RequestParam UUID customerId, @RequestParam UUID merchantId, @RequestParam StatusOrder status) {
        return ResponseEntity.ok(orderService.findFiltered(new OrderFilter(customerId, merchantId, status)));
    }

    @GetMapping("/{id}")
    ResponseEntity findOne(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.findOne(id));
    }
}
