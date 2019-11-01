package com.nchomework.algorithms;

import java.util.Random;

public class DoubleDimArrays {

    private DoubleDimArrays() {}

    public static int[][] generateMatrix(int height, int width, int min, int max) {
        int[][] matrix = new int[height][width];
        Random rnd = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = rnd.nextInt(max - min + 1) + min;
            }
        }
        return matrix;
    }

    public static int sumMainDiag(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int sumSideDiag(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public static int prodMainDiag(int[][] matrix) {
        int prod = 1;
        for (int i = 0; i < matrix.length; i++) {
            prod *= matrix[i][i];
        }
        return prod;
    }

    public static int prodSideDiag(int[][] matrix) {
        int prod = 1;
        for (int i = 0; i < matrix.length; i++) {
            prod *= matrix[i][matrix.length - 1 - i];
        }
        return prod;
    }

    public static int[] findMax(int[][] matrix) {
        int iMax = 0, jMax = 0;
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int index = SingleDimArrays.findMax(matrix[i]);
            if (matrix[i][index] > max) {
                max = matrix[i][index];
                iMax = i;
                jMax = index;
            }
        }
        return new int[]{iMax, jMax};
    }

    public static int[] findMin(int[][] matrix) {
        int iMin = 0, jMin = 0;
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int index = SingleDimArrays.findMax(matrix[i]);
            if (matrix[i][index] < min) {
                min = matrix[i][index];
                iMin = i;
                jMin = index;
            }
        }
        return new int[]{iMin, jMin};
    }
}
