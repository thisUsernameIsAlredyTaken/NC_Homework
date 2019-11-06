package com.nchomework.algorithms;

public class MyMath {

    private MyMath() {}

    public static long recursiveFactorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }

    public static long loopFactorial(long n) {
        if (n <= 0) {
            return 1;
        }
        long result = 1;
        for (long i = n; i > 0; i--) {
            result *= n;
        }
        return result;
    }
}
