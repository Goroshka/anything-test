package com.koldakov.algorithms.runningmedian;

import com.koldakov.datastructures.MyLinkedList;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
public class RunningMedianApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("(\r\n|[\r\n])?");

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        for (int i = 0; i < numLines; i++) {
            int nextValue = scanner.nextInt();

            linkedList.add(nextValue);
            linkedList.sort(Integer::compareTo);

            double res;
            if (i == 0) {
                res = linkedList.get(i);
            // even i means odd number of elements
            } else if (i % 2 == 0) {
                res = linkedList.get(i / 2);
            } else {
                int index = i / 2;
                res = (linkedList.get(index) + linkedList.get(index + 1)) / 2d;
            }
            System.out.println(res);
        }

        scanner.close();
    }
}
