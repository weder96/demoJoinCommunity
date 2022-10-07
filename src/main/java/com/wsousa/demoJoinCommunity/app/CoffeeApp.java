package com.wsousa.demoJoinCommunity.app;

import com.wsousa.demoJoinCommunity.domain.Coffee;
import com.wsousa.demoJoinCommunity.domain.CoffeeBean;
import com.wsousa.demoJoinCommunity.services.CoffeeMachine;
import com.wsousa.demoJoinCommunity.services.impl.BasicCoffeeMachine;
import com.wsousa.demoJoinCommunity.services.impl.PremiumCoffeeMachine;
import com.wsousa.demoJoinCommunity.enums.CoffeeSelection;
import com.wsousa.demoJoinCommunity.exceptions.CoffeeException;

import java.util.HashMap;
import java.util.Map;

public class CoffeeApp {

    private CoffeeMachine coffeeMachine;

    public CoffeeApp(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public Coffee prepareCoffee(CoffeeSelection selection) throws CoffeeException {
        Coffee coffee =  this.coffeeMachine.brewCoffee(selection);
        System.out.println("Coffee is ready! "+ selection.name());
        return coffee;
    }

    public static void main(String[] args) {
        CoffeeApp.MakePremiumCoffee();
        CoffeeApp.MakeBasicCoffee();
    } // end main

    public static  void MakePremiumCoffee(){
        // create a Map of available coffee beans
        Map<CoffeeSelection, CoffeeBean> beans = new HashMap<CoffeeSelection, CoffeeBean>();
        beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean(
                "My favorite espresso bean", 1000));
        beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean(
                "My favorite filter coffee bean", 1000));

        // get a new CoffeeMachine object
        PremiumCoffeeMachine machine = new PremiumCoffeeMachine(beans);

        // Instantiate CoffeeApp
        CoffeeApp app = new CoffeeApp(machine);

        // brew a fresh coffee
        try {
            app.prepareCoffee(CoffeeSelection.ESPRESSO);
        } catch (CoffeeException e) {
            e.printStackTrace();
        }
    }

    public static  void MakeBasicCoffee(){
        // create a Map of available coffee beans
        Map<CoffeeSelection, CoffeeBean> beans = new HashMap<CoffeeSelection, CoffeeBean>();
        beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean(
                "My favorite espresso bean", 1000));
        beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean(
                "My favorite filter coffee bean", 1000));

        // get a new CoffeeMachine object
        BasicCoffeeMachine machine = new BasicCoffeeMachine(beans);

        // Instantiate CoffeeApp
        CoffeeApp app = new CoffeeApp(machine);

        // brew a fresh coffee
        try {
            app.prepareCoffee(CoffeeSelection.FILTER_COFFEE);
        } catch (CoffeeException e) {
            e.printStackTrace();
        }
    }
} // end CoffeeApp
