package com.koldakov.pattern.visitor;

public class Apple implements Fruit {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
