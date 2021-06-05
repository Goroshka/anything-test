package com.koldakov.pattern.observer;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
