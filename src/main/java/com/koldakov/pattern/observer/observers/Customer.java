package com.koldakov.pattern.observer.observers;

import com.koldakov.pattern.observer.Observable;
import com.koldakov.pattern.observer.Observer;
import com.koldakov.pattern.observer.observables.Store;

public class Customer implements Observer {

    @Override
    public void update(Observable observable) {
        if (((Store) observable).isOpened()) {
            System.out.println("Customer: it's time to go shopping!");
        } else {
            System.out.println("Customer: it's time to go home!");
        }
    }
}
