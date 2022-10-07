package com.wsousa.demoJoinCommunity.app;

import java.math.BigDecimal;

public class CoffeeCyclomaticComplexity {

    public static void main(String[] args) {
        // System.out.println("Price Coffee : "+ new CoffeeCyclomaticComplexity().priceCoffee(false, true, 20));
        System.out.println("Price Coffee : "
                + new CoffeeCyclomaticComplexity().priceCoffeeRefactory(true, true, 20));
    }

    private BigDecimal priceCoffee(boolean premium, boolean express, int special){
        BigDecimal preco = BigDecimal.ZERO;
        if(premium){
            preco = BigDecimal.valueOf(20);
            if(express){
                preco = preco.add(BigDecimal.valueOf(2));
                if(special > 1){
                    preco = preco.add(BigDecimal.valueOf(2));
                } else {
                    preco = preco.add(BigDecimal.valueOf(1));
                }
            } else {
                preco = preco.add(BigDecimal.valueOf(1));
            }
        } else {
            preco = preco.add(BigDecimal.valueOf(15))
                         .add(BigDecimal.valueOf(1))
                         .add(BigDecimal.valueOf(1));
        }
        return preco;
    }

    private BigDecimal priceCoffeeRefactory(boolean premium, boolean express, int special){
        BigDecimal preco = BigDecimal.ZERO;
        if(premium){
            preco = BigDecimal.valueOf(20);
            preco = computePriceExpressCoffee(express, special, preco);
        } else {
            preco = computePriceCoffeeComplex(preco);
        }
        return preco;
    }

    private BigDecimal computePriceExpressCoffee(boolean express, int special, BigDecimal preco) {
        if(express){
            preco = computePriceCoffeeBasic(preco, 2L);
            preco = computePriceSpecialCoffee(special, preco);
        } else {
            preco = computePriceCoffeeBasic(preco, 1L);
        }
        return preco;
    }

    private BigDecimal computePriceSpecialCoffee(int special, BigDecimal preco) {
        if(special > 1){
            preco =  computePriceCoffeeBasic(preco, 2);
        } else {
            preco = computePriceCoffeeBasic(preco, 1L);
        }
        return preco;
    }

    private BigDecimal computePriceCoffeeBasic(BigDecimal preco, double valueAdd){
         return preco.add(BigDecimal.valueOf(valueAdd));
    }
    private BigDecimal computePriceCoffeeComplex(BigDecimal preco) {
        return preco.add(BigDecimal.valueOf(15))
                .add(BigDecimal.valueOf(1))
                .add(BigDecimal.valueOf(1));
    }

}
