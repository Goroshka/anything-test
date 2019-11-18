package com.koldakov.visitorpattern;

public class Orange implements Fruit {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
