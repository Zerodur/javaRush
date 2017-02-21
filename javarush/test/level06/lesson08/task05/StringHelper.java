package com.javarush.test.level06.lesson08.task05;

/* Класс StringHelper
Cделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) – возвращает строку повторенную count раз.
String multiply(String s) – возвращает строку повторенную 5 раз.
Пример:
Амиго -> АмигоАмигоАмигоАмигоАмиго
*/

public class StringHelper
{
    public static String multiply(String s)
    {
        String result = "";
        result = s+s+s+s+s;
        return result;
    }

    public static String multiply(String s, int count)
    {
        String result = "";
        for (int i = 1; i <= count; i++)
        {
            result += s;
        }
        return result;
    }

    public  static void main(String[] args)
    {
        String str = multiply("Амиго");
        System.out.println(str);

        str = multiply("Амиго", 3);
        System.out.println(str);

    }




}
