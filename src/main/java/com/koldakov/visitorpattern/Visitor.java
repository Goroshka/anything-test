package com.koldakov.visitorpattern;

public interface Visitor {
    void visit(Apple fruit);
    void visit(Orange fruit);
}
