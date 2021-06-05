package com.koldakov.pattern.visitor;

public class FruitPreparationVisitor implements Visitor {

    @Override
    public void visit(Apple fruit) {
        System.out.println("Cutting apple...");
    }

    @Override
    public void visit(Orange fruit) {
        System.out.println("Peeling orange...");
    }
}
