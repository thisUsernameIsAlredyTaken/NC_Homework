package com.example;

import com.example.collection.MyArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Sample {

    private static double average(double... nums) {
        double sum = 0.0;
        for (double num : nums) {
            sum += num;
        }
        return sum / nums.length;
    }

    public static void myCollectionPerformance(String... args) {
        for (String arg : args) {
            final int repeat = 8;
            final int size = Integer.parseInt(arg);
            final int index = size / 2;
            MyArrayList<Integer> custList = new MyArrayList<>();
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

    public static void javaCollectionPerformance(String... args) {
        final int repeat = 1;
        // Begin
        System.out.println("Begin");
        for (String arg : args) {
            final int size = Integer.parseInt(arg);
            final int index = 0;
            List<Integer> arrayList = new Vector<>();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(i + 1);
                linkedList.add(i + 1);
            }

            double[] arrayAddTimes = new double[repeat];
            double[] arrayGetTimes = new double[repeat];
            double[] arrayDelTimes = new double[repeat];
            double[] linkedAddTimes = new double[repeat];
            double[] linkedGetTimes = new double[repeat];
            double[] linkedDelTimes = new double[repeat];

            for (int i = 0; i < repeat; i++) {
                arrayAddTimes[i] = System.nanoTime();
                arrayList.add(index, 0);
                arrayAddTimes[i] = System.nanoTime() - arrayAddTimes[i];

                arrayGetTimes[i] = System.nanoTime();
                arrayList.get(index);
                arrayGetTimes[i] = System.nanoTime() - arrayGetTimes[i];

                arrayDelTimes[i] = System.nanoTime();
                arrayList.remove(index);
                arrayDelTimes[i] = System.nanoTime() - arrayDelTimes[i];

                linkedAddTimes[i] = System.nanoTime();
                linkedList.add(index, 0);
                linkedAddTimes[i] = System.nanoTime() - linkedAddTimes[i];

                linkedGetTimes[i] = System.nanoTime();
                linkedList.get(index);
                linkedGetTimes[i] = System.nanoTime() - linkedGetTimes[i];

                linkedDelTimes[i] = System.nanoTime();
                linkedList.remove(index);
                linkedDelTimes[i] = System.nanoTime() - linkedDelTimes[i];
            }

            System.out.println("List size: " + size);
            System.out.println("\tArray list:");
            System.out.printf("\t\tAdd: %f\n", average(arrayAddTimes));
            System.out.printf("\t\tGet: %f\n", average(arrayGetTimes));
            System.out.printf("\t\tDel: %f\n", average(arrayDelTimes));
            System.out.println("\tLinked list:");
            System.out.printf("\t\tAdd: %f\n", average(linkedAddTimes));
            System.out.printf("\t\tGet: %f\n", average(linkedGetTimes));
            System.out.printf("\t\tDel: %f\n", average(linkedDelTimes));
            System.out.println();
            System.out.println();
            System.out.flush();
        }
        System.out.println();
        System.out.println();

        // Middle
        System.out.println("Middle");
        for (String arg : args) {
            final int size = Integer.parseInt(arg);
            final int index = size / 2;
            ArrayList<Integer> arrayList = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(i + 1);
                linkedList.add(i + 1);
            }

            double[] arrayAddTimes = new double[repeat];
            double[] arrayGetTimes = new double[repeat];
            double[] arrayDelTimes = new double[repeat];
            double[] linkedAddTimes = new double[repeat];
            double[] linkedGetTimes = new double[repeat];
            double[] linkedDelTimes = new double[repeat];

            for (int i = 0; i < repeat; i++) {
                arrayAddTimes[i] = System.nanoTime();
                arrayList.add(index, 0);
                arrayAddTimes[i] = System.nanoTime() - arrayAddTimes[i];

                arrayGetTimes[i] = System.nanoTime();
                arrayList.get(index);
                arrayGetTimes[i] = System.nanoTime() - arrayGetTimes[i];

                arrayDelTimes[i] = System.nanoTime();
                arrayList.remove(index);
                arrayDelTimes[i] = System.nanoTime() - arrayDelTimes[i];

                linkedAddTimes[i] = System.nanoTime();
                linkedList.add(index, 0);
                linkedAddTimes[i] = System.nanoTime() - linkedAddTimes[i];

                linkedGetTimes[i] = System.nanoTime();
                linkedList.get(index);
                linkedGetTimes[i] = System.nanoTime() - linkedGetTimes[i];

                linkedDelTimes[i] = System.nanoTime();
                linkedList.remove(index);
                linkedDelTimes[i] = System.nanoTime() - linkedDelTimes[i];
            }

            System.out.println("List size: " + size);
            System.out.println("\tArray list:");
            System.out.printf("\t\tAdd: %f\n", average(arrayAddTimes));
            System.out.printf("\t\tGet: %f\n", average(arrayGetTimes));
            System.out.printf("\t\tDel: %f\n", average(arrayDelTimes));
            System.out.println("\tLinked list:");
            System.out.printf("\t\tAdd: %f\n", average(linkedAddTimes));
            System.out.printf("\t\tGet: %f\n", average(linkedGetTimes));
            System.out.printf("\t\tDel: %f\n", average(linkedDelTimes));
            System.out.println();
            System.out.println();
            System.out.flush();
        }
        System.out.println();
        System.out.println();

        // End
        System.out.println("End");
        for (String arg : args) {
            final int size = Integer.parseInt(arg);
            final int index = size - 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(i + 1);
                linkedList.add(i + 1);
            }

            double[] arrayAddTimes = new double[repeat];
            double[] arrayGetTimes = new double[repeat];
            double[] arrayDelTimes = new double[repeat];
            double[] linkedAddTimes = new double[repeat];
            double[] linkedGetTimes = new double[repeat];
            double[] linkedDelTimes = new double[repeat];

            for (int i = 0; i < repeat; i++) {
                arrayAddTimes[i] = System.nanoTime();
                arrayList.add(index, 0);
                arrayAddTimes[i] = System.nanoTime() - arrayAddTimes[i];

                arrayGetTimes[i] = System.nanoTime();
                arrayList.get(index);
                arrayGetTimes[i] = System.nanoTime() - arrayGetTimes[i];

                arrayDelTimes[i] = System.nanoTime();
                arrayList.remove(index);
                arrayDelTimes[i] = System.nanoTime() - arrayDelTimes[i];

                linkedAddTimes[i] = System.nanoTime();
                linkedList.add(index, 0);
                linkedAddTimes[i] = System.nanoTime() - linkedAddTimes[i];

                linkedGetTimes[i] = System.nanoTime();
                linkedList.get(index);
                linkedGetTimes[i] = System.nanoTime() - linkedGetTimes[i];

                linkedDelTimes[i] = System.nanoTime();
                linkedList.remove(index);
                linkedDelTimes[i] = System.nanoTime() - linkedDelTimes[i];
            }

            System.out.println("List size: " + size);
            System.out.println("\tArray list:");
            System.out.printf("\t\tAdd: %f\n", average(arrayAddTimes));
            System.out.printf("\t\tGet: %f\n", average(arrayGetTimes));
            System.out.printf("\t\tDel: %f\n", average(arrayDelTimes));
            System.out.println("\tLinked list:");
            System.out.printf("\t\tAdd: %f\n", average(linkedAddTimes));
            System.out.printf("\t\tGet: %f\n", average(linkedGetTimes));
            System.out.printf("\t\tDel: %f\n", average(linkedDelTimes));
            System.out.println();
            System.out.println();
            System.out.flush();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
//        MyArrayList<Integer> list = new MyArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(i + 1);
//        }
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
//        myCollectionPerformance(args);

        javaCollectionPerformance(args);
    }
}
// 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000 1100000 1200000 1300000 1400000 1500000 1600000 1700000 1800000 1900000 2000000
