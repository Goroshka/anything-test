/**
 * Based on https://www.baeldung.com/java-visitor-pattern
 *
 * Main idea is that if you have an object (FruitBasket) that contains list of different objects (Fruit),
 * you may add new functionality for handling this objects without adding new methods to them (i.e without modifying them)
 *
 * New functionality is represented by different visitors (FruitGreetingVisitor, FruitPreparationVisitor)
 * Handling of objects is achieved by implementing method which accepts visitor
 *
 */
package com.koldakov.visitorpattern;
