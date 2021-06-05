package com.koldakov.pattern.visitor;

public interface Fruit {
    void accept(Visitor v);
}
