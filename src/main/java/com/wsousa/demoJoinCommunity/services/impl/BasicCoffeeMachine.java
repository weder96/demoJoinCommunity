package com.wsousa.demoJoinCommunity.services.impl;

import com.wsousa.demoJoinCommunity.config.Configuration;
import com.wsousa.demoJoinCommunity.domain.*;
import com.wsousa.demoJoinCommunity.enums.CoffeeSelection;
import com.wsousa.demoJoinCommunity.exceptions.CoffeeException;
import com.wsousa.demoJoinCommunity.services.CoffeeMachine;

import java.util.HashMap;
import java.util.Map;

public class BasicCoffeeMachine implements CoffeeMachine {

    private final Map<CoffeeSelection, Configuration> configMap;

    private Map<CoffeeSelection, CoffeeBean> beans;

    private BrewingUnit brewingUnit;

    public BasicCoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
        this.beans = beans;
        this.brewingUnit = new BrewingUnit();

        this.configMap = new HashMap<>();
        this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
        this.configMap.put(CoffeeSelection.ESPRESSO, new Configuration(8, 28));
    }

    @Override
    public CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException {

        if(selection.equals(CoffeeSelection.FILTER_COFFEE))
            return brewFilterCoffee();

        throw new CoffeeException("CoffeeSelection ["+selection+"] not supported!");
    }
    private CoffeeDrink brewFilterCoffee() {
        Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE,  null, config.getQuantityWater());
    }

    public void addGroundCoffee(CoffeeSelection sel, CoffeeBean newBeans) throws CoffeeException {
        CoffeeBean existingBeans = this.beans.get(sel);
        if (existingBeans != null) {
            if (existingBeans.getName().equals(newBeans.getName())) {
                existingBeans.setQuantity(existingBeans.getQuantity() + newBeans.getQuantity());
            } else {
                throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.beans.put(sel, newBeans);
        }
    }
}
