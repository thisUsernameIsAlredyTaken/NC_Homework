package com.nchomework;

public class MyPrinter {

    private MyPrinter() {}

    public static void printRectangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

    public static void printTriangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

    public static void printZ(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print('#');
        }
        System.out.println();
        for (int i = size - 2; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }
            System.out.println('#');
        }
        for (int i = 0; i < size; i++) {
            System.out.print('#');
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int element :
                array) {
            System.out.print(element + "  ");
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            printArray(array);
        }
    }
}
