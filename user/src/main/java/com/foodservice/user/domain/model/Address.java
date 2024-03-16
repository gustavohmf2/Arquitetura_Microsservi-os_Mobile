package com.foodservice.user.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String state;
    private String city;
    private String neighborhood;
    private Integer number;

    public Address(String state, String city, String neighborhood, Integer number) {
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.number = number;
    }

    public Address() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
