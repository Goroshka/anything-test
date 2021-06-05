package com.koldakov.pattern.visitor;

public interface Visitor {
    void visit(Apple fruit);
    void visit(Orange fruit);
}
