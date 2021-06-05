package com.koldakov.pattern.visitor;

public class VisitorTestDrive {

    public static void main(String[] args) {
        FruitBasket fruitBasket = new FruitBasket();
        fruitBasket.addFruit(new Apple());
        fruitBasket.addFruit(new Orange());

        // visit fruits by one visitor
        fruitBasket.visitFruits(new FruitGreetingVisitor());

        // visit fruits by another visitor
        fruitBasket.visitFruits(new FruitPreparationVisitor());
    }
}
