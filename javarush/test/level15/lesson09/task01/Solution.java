package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1d, "One");
        labels.put(2d, "Two");
        labels.put(3d, "Three");
        labels.put(4d, "Four");
        labels.put(5d, "Five");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
