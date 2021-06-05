package com.koldakov.pattern.observer.observables;

import com.koldakov.pattern.observer.Observable;
import com.koldakov.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Store implements Observable {

    private boolean opened;

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Store: " + (opened ? "opened" : "closed"));

        for (Observer o : observers) {
            o.update(this);
        }
//        observers.forEach(o -> o.update(this));
        System.out.println();
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
        notifyObservers();
    }

    public boolean isOpened() {
        return opened;
    }
}
