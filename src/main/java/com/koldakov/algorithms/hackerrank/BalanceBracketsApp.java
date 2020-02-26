package com.koldakov.algorithms.hackerrank;

import java.util.*;

/*
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
public class BalanceBracketsApp {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("(\r\n|[\r\n])?");

        List<String> results = new ArrayList<>();
        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();

            results.add(String.format("Brackets '%s' %sbalanced", line, isBalanced(line) ? "" : "NOT "));
        }

        results.forEach(System.out::println);

        scanner.close();
    }

    private static boolean isBalanced(String bracketsString) {
        Stack<Character> bracketsStack = new Stack<>();

        Map<Character, Character> closeOpenMap = new HashMap<>();
        closeOpenMap.put(')', '(');
        closeOpenMap.put(']', '[');
        closeOpenMap.put('}', '{');

        for (int i = 0; i < bracketsString.length(); i++) {
            Character currentBracket = bracketsString.charAt(i);
            if (closeOpenMap.containsKey(currentBracket)) {
                if (bracketsStack.empty()) {
                    return false;
                }
                if (closeOpenMap.get(currentBracket) != bracketsStack.pop()) {
                    return false;
                }
            } else {
                bracketsStack.push(currentBracket);
            }
        }
        return bracketsStack.empty();
    }
}
