package com.koldakov.algorithms.sorting;

public class InsertionSortAlg {

    /*
    like sort playing cards in hand
    for each element:
        insert it into sorted array of previous elements
    */
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 3, 2};

        sort(array);

        Printer.printArray(array);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            // move elements to one to the right, if they are bigger than current
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            // since last operation was j--, we need to add 1, and write current there
            array[j + 1] = current;
        }
    }
}
