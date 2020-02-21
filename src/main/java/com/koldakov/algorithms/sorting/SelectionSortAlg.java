package com.koldakov.algorithms.sorting;

public class SelectionSortAlg {

    /*
    for each element:
        find element with minimum value less than current in rest part of array ('right side') and swap them
     */
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 3, 2};

        for (int i = 0; i < array.length - 1; i++) {
            int minimumIdx = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimumIdx]) {
                    minimumIdx = j;
                }
            }

            int temp = array[i];
            array[i] = array[minimumIdx];
            array[minimumIdx] = temp;

            Printer.printArray(array);
        }

        Printer.printArray(array);
    }
}
