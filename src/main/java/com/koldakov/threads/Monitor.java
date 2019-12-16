package com.koldakov.threads;

import java.io.IOException;

/**
 * "wait <-> notify/notifyAll" sample
 * wait, notify, notifyAll methods must be called in synchronized block or method
 *
 * synchronized block of wait acquires lock, releases lock prior to waiting and reacquires lock prior to returning from the wait() method
 * synchronized block of notify/notifyAll must acquire lock, about which it is going to notify other
 *
 * In general, lock must be used to ensure that checking the condition and setting the condition is atomic.
 * That can be achieved by using 'synchronized'
 *
 * Without synchronized a race condition can occur:
 * - Thread-1: checks flag and see that it must wait
 * - Thread-2: sets flag
 * - Thread-2: notifies all (i.e. nobody since no thread is waiting yet)
 * - Thread-1: calls wait and waits infinitely
 *
 * Using wait and notify without flag does not make much sense, because
 * wait can be called after notify and thread will wait infinitely
 */
public class Monitor {

    private static final Monitor instance = new Monitor();
    private static boolean flag = false;

    private static void waitMethod() {
        synchronized (instance) {
            try {
                while (!flag) {
                    System.out.println("Waiting in thread " + Thread.currentThread().getName());
                    instance.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Processing in thread " + Thread.currentThread().getName());
    }

    private static void notifyAllMethod() {
        synchronized (instance) {
            System.out.println("Notifying all in thread " + Thread.currentThread().getName());
            instance.notifyAll();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Press any key after you see two \"Waiting ...\" messages");

        new Thread(Monitor::waitMethod).start();
        new Thread(Monitor::waitMethod).start();

        System.in.read();

        synchronized (instance) {
            flag = true;
            Monitor.notifyAllMethod();
        }
    }
}
