package com.koldakov.threads;

public class Interruption {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("In catch curr = " + Thread.currentThread().isInterrupted());
                System.out.println("In catch = " + Thread.interrupted());
                e.printStackTrace();
                Thread.currentThread().interrupt();
                System.out.println("In catch after interrupt curr = " + Thread.currentThread().isInterrupted());
                System.out.println("In catch after interrupt = " + Thread.interrupted());
            }

//            System.out.println("After try-catch = " + Thread.interrupted());
        });
        t1.start();

        Thread.sleep(1000);

        System.out.println("Interrupting t1");
        t1.interrupt();
    }
}
