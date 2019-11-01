package com.nchomework.algorithms;

import java.util.Random;

public class SingleDimArrays {

    private SingleDimArrays() {}

    public static int product(int[] array) {
        int prod = 1;
        for (int elem : array) {
            prod *= elem;
        }
        return prod;
    }

    public static int[] generateArray(int size, int min, int max) {
        Random rnd = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static int[] generateRange(int min, int max, int step) {
        int[] array = new int[(max - min + 1) / step + 1];
        array[0] = min;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + step;
        }
        return array;
    }

    public static int[] reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int iMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    iMin = j;
                }
            }
            if (iMin != i) {
                int tmp = array[i];
                array[i] = array[iMin];
                array[iMin] = tmp;
            }
        }
        return array;
    }

    public static int findMax(int[] array) {
        int iMax = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                iMax = i;
                max = array[i];
            }
        }
        return iMax;
    }

    public static int findMin(int[] array) {
        int iMin = 0;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                iMin = i;
                min = array[i];
            }
        }
        return iMin;
    }

    public static double average(int[] array) {
        double sum = 0;
        for (int element :
                array) {
            sum += element;
        }
        return sum / array.length;
    }
}
