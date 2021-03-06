package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution {
    static Object lock = new Object();
    public static int getRandomIntegerBetweenNumbers(int from, int to) {

        synchronized (lock)
        {
            return ThreadLocalRandom.current().nextInt(from, to);
        }
    }

    public static double getRandomDouble() {
        synchronized (lock)
        {
            return ThreadLocalRandom.current().nextDouble();
        }
    }

    public static long getRandomLongBetween0AndN(long n) {
        synchronized (lock)
        {
            return ThreadLocalRandom.current().nextLong(n);
        }
    }
}
