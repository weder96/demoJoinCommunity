package com.wsousa.demoJoinCommunity.services;

import com.wsousa.demoJoinCommunity.domain.Coffee;
import com.wsousa.demoJoinCommunity.enums.CoffeeSelection;
import com.wsousa.demoJoinCommunity.exceptions.CoffeeException;

public interface CoffeeMachine {
    Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException;
}
