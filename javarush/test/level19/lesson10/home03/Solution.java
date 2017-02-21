package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy");
        while(reader.ready()){
            String line = reader.readLine();
            String[] words = line.split(" ");
            String date = words[words.length - 3] + " " + words[words.length - 2] + " " + words[words.length - 1];
            String name = line.replaceAll(" " + date, "");
            PEOPLE.add(new Person(name, dateFormat.parse(date)));

        }
        reader.close();
    }

}
