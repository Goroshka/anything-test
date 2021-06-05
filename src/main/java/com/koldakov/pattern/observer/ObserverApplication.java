package com.koldakov.pattern.observer;

import com.koldakov.pattern.observer.observables.Store;
import com.koldakov.pattern.observer.observers.Customer;
import com.koldakov.pattern.observer.observers.Thief;

public class ObserverApplication {

    public static void main(String[] args) {
        Store store = new Store();

        store.registerObserver(new Customer());
        store.registerObserver(new Thief());

        store.setOpened(true);
        store.setOpened(false);
    }
}
