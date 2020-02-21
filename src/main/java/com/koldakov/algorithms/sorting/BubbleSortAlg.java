package com.koldakov.algorithms.sorting;

public class BubbleSortAlg {

    /*
    for each element:
        if it is bigger than next element, swap them

    optimization - break outer loop if there were no swaps in inner loop
    in this example both algorithms are equal
    */
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 3, 2};

        sort(array);
        Printer.printArray(array);

        array = new int[]{4, 5, 1, 6, 3, 2};

        optimizedSort(array);
        Printer.printArray(array);
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void optimizedSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
