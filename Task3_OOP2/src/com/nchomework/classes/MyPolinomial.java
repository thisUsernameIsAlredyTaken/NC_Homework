package com.nchomework.classes;

import java.util.Arrays;

public class MyPolinomial {

    private double[] coeffs;

    private String monomToString(int index) {
        if (coeffs[index] == 0.0) {
            return "";
        }
        if (index == 0) {
            if (coeffs[index] > 0) {
                return "+" + coeffs[index];
            }
            return "" + coeffs[index];
        }
        if (coeffs[index] > 0) {
            return "+" + coeffs[index] + "X^" + index + " ";
        }
        return "" + coeffs[index] + "X^" + index + " ";
    }

    public MyPolinomial(double...coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result += monomToString(i);
        }
        if (result == "") {
            return "0";
        }
        return result;
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result += Math.pow(x, i) * coeffs[i];
        }
        return result;
    }

    public MyPolinomial add(MyPolinomial right) {
        MyPolinomial result;
        MyPolinomial argument;
        if (coeffs.length > right.coeffs.length) {
            result = new MyPolinomial(coeffs);
            argument = right;
        } else {
            result = new MyPolinomial(right.coeffs);
            argument = this;
        }
        for (int i = 0; i < argument.coeffs.length; i++) {
            result.coeffs[i] += argument.coeffs[i];
        }
        return result;
    }

    public MyPolinomial multiply(MyPolinomial right) {
        int maxPow = (this.coeffs.length - 1) +
                (right.coeffs.length - 1);
        double[] coeffs = new double[maxPow];
        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                coeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolinomial(coeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolinomial that = (MyPolinomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        if (coeffs == null)
            return 0;

        int result = 1;
        for (double element : coeffs) {
            long bits = Double.doubleToLongBits(element);
            result = 31 * result + (int)(bits ^ (bits >>> 32));
        }
        return result;
    }
}
