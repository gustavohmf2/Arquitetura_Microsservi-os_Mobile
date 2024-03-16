package com.foodservice.product.domain.model;

import java.util.UUID;

public class Product {
    private String name;
    private String description;
    private Double price;
    private UUID merchant;

    public Product(String name, String description, Double price, UUID merchant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.merchant = merchant;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public UUID getMerchant() {
        return merchant;
    }

    public void setMerchant(UUID merchant) {
        this.merchant = merchant;
    }
}
