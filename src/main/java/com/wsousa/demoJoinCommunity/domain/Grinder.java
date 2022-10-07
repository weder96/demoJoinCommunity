package com.wsousa.demoJoinCommunity.domain;

public class Grinder {

    public GroundCoffee grind(CoffeeBean coffeeBean, double quantityCoffee) {
        System.out.println(coffeeBean.getName());
        System.out.println(quantityCoffee);
        return new GroundCoffee(coffeeBean.getName(), quantityCoffee);
    }

}
