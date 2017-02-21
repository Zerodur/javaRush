package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File your_file_name = File.createTempFile("e:\\test2", null);
            OutputStream outputStream = new FileOutputStream("e:\\test2.txt");
            InputStream inputStream = new FileInputStream("e:\\test2.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            Human petrov = new Human("Petrov", new Asset("girl"), new Asset("moto"), new Asset("apartments"));
            petrov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human("Petrov");
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {

        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {

            if (this.name == null || this.name == "") return;

            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(name);
            if (assets != null){
                writer.println(assets.size());
                for (Asset asset : assets){
                    writer.println(asset.getName());
                    writer.println(String.valueOf(asset.getPrice()));
                }
            }
            writer.println();
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (this.name == null)
            {
                if (reader.ready())
                {
                    this.name = reader.readLine();
                    int size = Integer.valueOf(reader.readLine());
                    for (int i = 0; i < size; i++){
                        this.assets.add(new Asset(reader.readLine()));
                        this.assets.get(0).setPrice(Double.valueOf(reader.readLine()));
                    }
                }
            }else {
                while (reader.ready()){
                    if (this.name.equals(reader.readLine())){
                        int size = Integer.valueOf(reader.readLine());
                        for (int i = 0; i < size; i++){
                            this.assets.add(new Asset(reader.readLine()));
                            this.assets.get(0).setPrice(Double.valueOf(reader.readLine()));
                        }
                        break;
                    }
                }
            }
        }
    }
}
