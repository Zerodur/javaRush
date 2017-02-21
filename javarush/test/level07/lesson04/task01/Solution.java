package com.javarush.test.level07.lesson04.task01;

import java.io.*;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array_in = new int[20];
        for (int i = 0; i < array_in.length; i++)
        {
            array_in[i] = Integer.parseInt(reader.readLine());
        }
        return array_in;
    }

    public static int max(int[] array)
    {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
        if (array[i] > max) max = array[i];
        return max;
    }
}
