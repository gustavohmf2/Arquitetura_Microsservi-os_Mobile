package com.foodservice.product.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private UUID merchant;

    public ProductEntity(UUID id, String name, String description, Double price, UUID merchant) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.merchant = merchant;
    }

    public ProductEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
