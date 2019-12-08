package com.example;

import com.example.collection.MyLinkedList;

import java.util.LinkedList;

public class Sample {

    private static double average(double... nums) {
        double sum = 0.0;
        for (double num : nums) {
            sum += num;
        }
        return sum / nums.length;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            final int repeat = 8;
            final int size = Integer.parseInt(arg);
            final int index = size / 2;
            MyLinkedList<Integer> custList = new MyLinkedList<>();
            LinkedList<Integer> javaList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                custList.add(i + 1);
                javaList.add(i + 1);
            }

            double[] javAddTimes = new double[repeat];
            double[] cusAddTimes = new double[repeat];
            double[] javGetTimes = new double[repeat];
            double[] cusGetTimes = new double[repeat];
            double[] javDelTimes = new double[repeat];
            double[] cusDelTimes = new double[repeat];

            for (int i = 0; i < repeat; i++) {
                cusAddTimes[i] = System.nanoTime();
                custList.add(index, 0);
                cusAddTimes[i] = System.nanoTime() - cusAddTimes[i];

                cusGetTimes[i] = System.nanoTime();
                custList.get(index);
                cusGetTimes[i] = System.nanoTime() - cusGetTimes[i];

                cusDelTimes[i] = System.nanoTime();
                custList.remove(index);
                cusDelTimes[i] = System.nanoTime() - cusDelTimes[i];

                javAddTimes[i] = System.nanoTime();
                javaList.add(index, 0);
                javAddTimes[i] = System.nanoTime() - javAddTimes[i];

                javGetTimes[i] = System.nanoTime();
                javaList.get(index);
                javGetTimes[i] = System.nanoTime() - javGetTimes[i];

                javDelTimes[i] = System.nanoTime();
                javaList.remove(index);
                javDelTimes[i] = System.nanoTime() - javDelTimes[i];
            }

            System.out.println("List size: " + size);
            System.out.println("\tJava list:");
            System.out.printf("\t\tAdd: %f\n", average(javAddTimes));
            System.out.printf("\t\tGet: %f\n", average(javGetTimes));
            System.out.printf("\t\tDel: %f\n", average(javDelTimes));
            System.out.println("\tMy list:");
            System.out.printf("\t\tAdd: %f\n", average(cusAddTimes));
            System.out.printf("\t\tGet: %f\n", average(cusGetTimes));
            System.out.printf("\t\tDel: %f\n", average(cusDelTimes));
            System.out.flush();
        }
    }
}
