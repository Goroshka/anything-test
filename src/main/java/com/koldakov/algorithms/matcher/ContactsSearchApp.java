package com.koldakov.algorithms.matcher;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/contacts/problem
 */
public class ContactsSearchApp {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("(\r\n|[\r\n])?");

        String[][] operationsStrings = new String[numLines][2];

        for (int i = 0; i < numLines; i++) {
            String[] operationString = scanner.nextLine().split(" ");
            operationsStrings[i] = operationString;
        }

        printMatches(operationsStrings);
    }

    private static void printMatches(String[][] operationsStrings) {
        for (int i = 0; i < operationsStrings.length; i++) {
            if (operationsStrings[i][0].equals("find")) {
                int coincidencesCount = 0;
                for (int j = 0; j < i; j++) {
                    if (operationsStrings[j][0].equals("add") && operationsStrings[j][1].startsWith(operationsStrings[i][1])) {
                        coincidencesCount++;
                    }
                }
                System.out.println(operationsStrings[i][1] + ": found " + coincidencesCount);
            }
        }
    }
}
