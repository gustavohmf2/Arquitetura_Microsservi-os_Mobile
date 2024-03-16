package com.foodservice.user.view.dto;

public record UserRegisterDTO(
        String registerNumber,
        String name,
        String email,
        String phone,
        String state,
        String city,
        String neighborhood,
        Integer number) {
}
