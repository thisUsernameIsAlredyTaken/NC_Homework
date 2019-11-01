package com.nchomework;

import com.nchomework.algorithms.MyMath;
import com.nchomework.algorithms.SingleDimArrays;

import java.util.Arrays;

import static com.nchomework.algorithms.DoubleDimArrays.*;
import static com.nchomework.algorithms.SingleDimArrays.*;

public class Sample {

    private static void sortsTest() {
        int[] array1 = SingleDimArrays.generateArray(40000, -1000000, 1000000);
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();

        long start = System.nanoTime();
        SingleDimArrays.bubbleSort(array1);
        long bubbleSortTime = System.nanoTime() - start;
        start = System.nanoTime();
        SingleDimArrays.selectionSort(array2);
        long selectionSortTime = System.nanoTime() - start;
        start = System.nanoTime();
        Arrays.sort(array3);
        long javaSortTime = System.nanoTime() - start;
        System.out.println("SORTS TEST:");
        System.out.println("          Bubble sort time: " + bubbleSortTime);
        System.out.println("       Selection sort time: " + selectionSortTime);
        System.out.println("java.util.Arrays sort time: " + javaSortTime);
        System.out.println();
    }

    private static void factorialTest() {
        long start = System.nanoTime();
        MyMath.recursiveFactorial(20);
        long recursiveFactorialTime = System.nanoTime() - start;
        start = System.nanoTime();
        MyMath.loopFactorial(20);
        long loopFactorialTime = System.nanoTime() - start;
        System.out.println("FACTORIAL TEST:");
        System.out.println("Recursive factorial time: " + recursiveFactorialTime);
        System.out.println("     Loop factorial time: " + loopFactorialTime);
        System.out.println();

    }

    private static void printerTest() {
        MyPrinter.printRectangle(5, 5);
        System.out.println();
        MyPrinter.printTriangle(8);
        System.out.println();
        MyPrinter.printZ(8);
        System.out.println();
    }

    private static void arrays1dTest() {
        int[] array = generateRange(1, 99, 2);
        MyPrinter.printArray(array);
        reverse(array);
        MyPrinter.printArray(array);
        System.out.println();
        
        array = generateArray(20,0, 10);
        MyPrinter.printArray(array);
        int odd = 0, even = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println(" Odds: " + odd);
        System.out.println("Evens: " + even);
        System.out.println();

        array = generateArray(10, 1, 100);
        MyPrinter.printArray(array);
        for (int i = 1; i < array.length; i += 2) {
            array[i] = 0;
        }
        MyPrinter.printArray(array);
        System.out.println();

        array = generateArray(15, -50, 50);
        MyPrinter.printArray(array);
        int iMin = findMin(array);
        int iMax = findMax(array);
        System.out.println("Maximum: " + array[iMax] + ". Position: " + iMax);
        System.out.println("Minimum: " + array[iMin] + ". Position: " + iMin);
        System.out.println();

        array = generateArray(10, 0, 10);
        double avg = average(array);
        MyPrinter.printArray(array);
        System.out.println("Average: " + avg);
        int[] array2 = generateArray(10, 0, 10);
        double avg2 = average(array2);
        MyPrinter.printArray(array2);
        System.out.println("Average: " + avg2);
        if (avg == avg2) {
            System.out.println("Averages are equal");
        } else if (avg < avg2) {
            System.out.println("Second average greater than first");
        } else {
            System.out.println("First average greater than second");
        }
        System.out.println();

        array = generateArray(20, -1, 1);
        MyPrinter.printArray(array);
        int[] counter = {0, 0, 0};
        for (int elem : array) {
            counter[elem + 1] += 1;
        }
        int max = counter[findMax(counter)];
        System.out.print("Most common (" + max + " times): ");
        for (int i = 0; i < 3; i++) {
            if (counter[i] == max) {
                System.out.print(i - 1 + ",  ");
            }
        }
        System.out.println();
    }

    private static void arrays2dTest() {
        int[][] matrix = generateMatrix(8, 8, 1, 99);
        MyPrinter.printMatrix(matrix);
        int mainDiagSum = sumMainDiag(matrix);
        int sideDiagSum = sumSideDiag(matrix);
        int mainDiagProd = prodMainDiag(matrix);
        int sideDiagProd = prodSideDiag(matrix);
        System.out.println("Main diagonal:");
        System.out.println("    Sum: " + mainDiagSum);
        System.out.println("Product: " + mainDiagProd);
        System.out.println("Side diagonal:");
        System.out.println("    Sum: " + sideDiagSum);
        System.out.println("Product: " + sideDiagProd);
        System.out.println();

        matrix = generateMatrix(8, 5, -99, 99);
        MyPrinter.printMatrix(matrix);
        int max[] = findMax(matrix);
        System.out.println("Maximum: " + matrix[max[0]][max[1]]);
        System.out.println("Position: (" + max[0] + ", " + max[1] + ")");
        System.out.println();

        matrix = generateMatrix(8, 5, -10, 10);
        MyPrinter.printMatrix(matrix);
        int[] products = new int[8];
        for (int i = 0; i < products.length; i++) {
            products[i] = Math.abs(product(matrix[i]));
        }
        System.out.println("Maximum product at line " + findMax(products));
        System.out.println();

        matrix = generateMatrix(10, 7, 0, 100);
        MyPrinter.printMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            reverse(matrix[i]);
        }
        System.out.println("Sorted matrix:");
        MyPrinter.printMatrix(matrix);
    }

    public static void main(String[] args) {
        sortsTest();
        factorialTest();
        printerTest();
        arrays1dTest();
        arrays2dTest();
    }
}
