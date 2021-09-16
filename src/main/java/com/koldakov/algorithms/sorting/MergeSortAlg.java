package com.koldakov.algorithms.sorting;


/*  1. Divide the unsorted list into N sublists, each containing 1 element.
    2. Take adjacent pairs of two singleton lists and merge them to form a sorted list of 2 elements.
       N will now convert into N / 2 lists of size 2.
    3. Repeat the process till a single sorted list of obtained.
 */
public class MergeSortAlg {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 3, 2};

        sort(arr);

        Printer.printArray(arr);
    }

    private static void sort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }

        // splitting in two arrays, for example {5, 3, 2, 6, 1} -> {5, 3} and {2, 6, 1}
        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = middle; i < length; i++) {
            rightArr[i - middle] = arr[i];
        }

        sort(leftArr);
        sort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0;
        int j = 0;
        int k = 0;

        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        // iterate both arrays while one or both of them will not be used up
        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // then add all remaining elements, if any.
        // remaining elements are sorted already and they are greater, than any element in the merge

        // in fact, only one or none of these loops will be executed
        while (i < leftLength) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
