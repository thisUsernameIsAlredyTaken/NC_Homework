package com.example;

import com.example.collection.MyLinkedList;

import java.util.LinkedList;

public class Sample {

    public static void main(String[] args) {
        final int size = 10000;
        final int index = size / 2;
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> javaList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + 1);
            javaList.add(i + 1);
        }

        double[] addTime = new double[2];
        double[] getTime = new double[2];
        double[] delTime = new double[2];

        addTime[0] = System.nanoTime();
        list.add(index, 0);
        addTime[0] = System.nanoTime() - addTime[0];

        getTime[0] = System.nanoTime();
        list.get(index);
        getTime[0] = System.nanoTime() - getTime[0];

        delTime[0] = System.nanoTime();
        list.remove(index);
        delTime[0] = System.nanoTime() - delTime[0];

        System.out.println("MyLinkedList:");
        System.out.println("\taddTime = " + addTime[0]);
        System.out.println("\tgetTime = " + getTime[0]);
        System.out.println("\tdelTime = " + delTime[0]);

        addTime[1] = System.nanoTime();
        javaList.add(index, 0);
        addTime[1] = System.nanoTime() - addTime[1];

        getTime[1] = System.nanoTime();
        javaList.get(index);
        getTime[1] = System.nanoTime() - getTime[1];

        delTime[1] = System.nanoTime();
        javaList.remove(index);
        delTime[1] = System.nanoTime() - delTime[1];

        System.out.println("JavaLinkedList");
        System.out.println("\taddTime = " + addTime[1]);
        System.out.println("\tgetTime = " + getTime[1]);
        System.out.println("\tdelTime = " + delTime[1]);

        System.out.println("Efficiency: ");
        System.out.println("Add: " + addTime[1] / addTime[0]);
        System.out.println("Get: " + getTime[1] / getTime[0]);
        System.out.println("Del: " + delTime[1] / delTime[0]);
    }
}
