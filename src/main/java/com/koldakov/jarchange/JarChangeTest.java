package com.koldakov.jarchange;

public class JarChangeTest {

    public static void main(String[] args) throws ClassNotFoundException {

//        Class.forName("qwer");

        JarChangeTest j = new JarChangeTest();
        j.sleep();

        new CalledClass().callMethod();
    }

    private void sleep() {
        int sleepTimeMs = 10_000;

        try {
            System.out.println("Sleep for " + sleepTimeMs);
            Thread.sleep(sleepTimeMs);
            System.out.println("Wake up");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
