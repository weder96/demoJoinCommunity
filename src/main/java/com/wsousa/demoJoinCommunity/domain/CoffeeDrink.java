package com.wsousa.demoJoinCommunity.domain;

import com.wsousa.demoJoinCommunity.enums.CoffeeSelection;
import com.wsousa.demoJoinCommunity.exceptions.CoffeeException;

public class CoffeeDrink extends  Coffee{

    private CoffeeSelection selection;

    private double quantity;

    public CoffeeDrink (CoffeeSelection selection, double quantity) {
        super(selection.name(), quantity);
        this.selection = selection;
        this.quantity = quantity;
    }

    public CoffeeSelection getSelection() {
        return selection;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) throws CoffeeException {
        if (quantity >= 0.0) {
            this.quantity = quantity;
        } else {
            throw new CoffeeException("Quantity has to be >= 0.0.");
        }
    }
}