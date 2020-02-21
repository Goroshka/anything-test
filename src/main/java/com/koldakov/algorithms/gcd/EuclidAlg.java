package com.koldakov.algorithms.gcd;

import java.util.Scanner;

public class EuclidAlg {

    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        Scanner scanner = new Scanner(System.in);
        scanner.skip("(\r\n|[\r\n])?");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int divisor = Math.min(a, b);
        int rest = Math.max(a, b) % divisor;

        while (rest != 0) {
            int tmp = rest;
            rest = divisor % rest;
            divisor = tmp;
        }

        System.out.println("GCD is " + divisor);

        scanner.close();
    }
}
