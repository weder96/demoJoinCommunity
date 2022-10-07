package com.wsousa.demoJoinCommunity.domain;

import com.wsousa.demoJoinCommunity.exceptions.CoffeeException;

public class Coffee {

    private String name;

    private double quantity;

    public Coffee(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) throws CoffeeException {
        this.quantity = quantity;
    }
}