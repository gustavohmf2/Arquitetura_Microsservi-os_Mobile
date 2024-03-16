package com.foodservice.product.view.dto;

import java.util.UUID;

public record RegisterProductDTO (
    String name,
    String description,
    Double price,
    UUID merchant
){}
