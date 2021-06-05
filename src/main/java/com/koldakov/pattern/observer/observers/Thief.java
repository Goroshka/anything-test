package com.koldakov.pattern.observer.observers;

import com.koldakov.pattern.observer.Observable;
import com.koldakov.pattern.observer.Observer;
import com.koldakov.pattern.observer.observables.Store;

public class Thief implements Observer {

    @Override
    public void update(Observable observable) {
        if (((Store) observable).isOpened()) {
            System.out.println("Thief: it's time to get out!");
        } else {
            System.out.println("Thief: it's time steal!");
        }
    }
}
