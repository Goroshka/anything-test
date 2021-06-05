package com.koldakov.pattern.visitor;

public class FruitGreetingVisitor implements Visitor {

    @Override
    public void visit(Apple fruit) {
        System.out.println("Hello, apple");
    }

    @Override
    public void visit(Orange fruit) {
        System.out.println("Hello, orange!");
    }
}
