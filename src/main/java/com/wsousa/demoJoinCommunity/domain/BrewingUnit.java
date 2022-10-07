package com.wsousa.demoJoinCommunity.domain;

import com.wsousa.demoJoinCommunity.enums.CoffeeSelection;

import java.util.Objects;

public class BrewingUnit {
    public CoffeeDrink brew(CoffeeSelection selection, GroundCoffee groundCoffee, double quantity) {
        System.out.println(Objects.isNull(groundCoffee) ? " " : groundCoffee.getName());
        System.out.println(quantity);
        return new CoffeeDrink(selection, quantity);
    }

}