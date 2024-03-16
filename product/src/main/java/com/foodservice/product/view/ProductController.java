package com.foodservice.product.view;

import com.foodservice.product.domain.service.ProductService;
import com.foodservice.product.view.dto.RegisterProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.foodservice.product.view.ProductMapper.mapToProduct;

@RestController
@RequestMapping("/products")
public record ProductController(ProductService productService) {

    @PostMapping
    ResponseEntity register(@RequestBody RegisterProductDTO registerProductDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.register(mapToProduct(registerProductDTO)));
    }

    @GetMapping
    ResponseEntity find(@RequestParam(required = false) UUID merchant) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.find());
    }

    @GetMapping("/{id}")
    ResponseEntity findOne(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.findOne(id));
    }
}
