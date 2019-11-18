package com.koldakov.visitorpattern;

import java.util.ArrayList;
import java.util.List;

class FruitBasket {

    private List<Fruit> fruits = new ArrayList<>();

    void visitFruits(Visitor v) {
        for (Fruit fruit : fruits) {
            fruit.accept(v);
        }
    }

    void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }
}
