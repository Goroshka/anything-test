package com.koldakov.algorithms;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CalculateSumVariants {

    public static void main(String[] args) {
        int[] ar = {290, 3700, 381, 11688, 1400, 55, 2864, 2000, 579, 2000, 1650, 35987, 1650};
        int resultSum = 56904;

        int answerCount = 0;
        for (Integer[] bitmap : generateBitmaps(ar.length)) {
            int currentSum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ar.length; i++) {
                sb.append(ar[i] * bitmap[i]).append(" + ");
                currentSum += ar[i] * bitmap[i];
            }
            if (currentSum == resultSum) {
                answerCount++;
                System.out.println(sb.replace(sb.lastIndexOf("+"), sb.lastIndexOf("+") + 1, "=").append(resultSum));
            }
        }
        if (answerCount == 0) {
            System.out.println("No variants found");
        }
    }

    private static Set<Integer[]> generateBitmaps(int arrayLength) {
        Set<Integer[]> result = new HashSet<>();
        for (int i = 0; i < Math.pow(2, arrayLength); i++) {
            String[] stringArray = StringUtils.leftPad(Integer.toBinaryString(i), arrayLength, '0').split("");
            Integer[] array = Arrays.stream(stringArray).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
            result.add(array);
        }
        return result;
    }
}
