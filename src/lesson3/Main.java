package lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //1. Получение уникальных значений
        System.out.println("Первое задание:");
        ArrayList<String> masWord = new ArrayList<>();
        // заполнение массива слов
        fillingMasWord(masWord);
        // вывод уникальных значений и количества повторений
        printUniqueWord(masWord);
        System.out.println();

        //2. телефонный справочник
        System.out.println("Второе задание:");
        // добавим тестовые данные
        // создаем людей с их номерами телефонов и добавляем/ поулчаем данные по фамилии
        TelephoneDirectory tel1 = new TelephoneDirectory();

        Person person1 = new Person("Вдовенко");
        person1.add("12345");
        person1.add("123456");

        tel1.setNewFamily("Вдовенко");
        tel1.add(person1);

        Person person2 = new Person("Иванов");
        person2.add("7653");

        tel1.setNewFamily("Иванов");
        tel1.add(person2);

        Person person3 = new Person("Петров");
        person3.add("1");
        person3.add("2");

        tel1.setNewFamily("Иванов");
        tel1.add(person3);

        tel1.get("Вдовенко");

    }

    private static void fillingMasWord(ArrayList<String> mas){
        mas.add("name1");
        mas.add("name2");
        mas.add("name3");
        mas.add("name4");
        mas.add("name5");
        mas.add("name6");
        mas.add("name7");
        mas.add("name7");
        mas.add("name7");
        mas.add("name8");
        mas.add("name8");
        mas.add("name9");
        mas.add("name9");
    }

    private static void printUniqueWord(ArrayList<String> mas){

        Set<String> mySet = new HashSet<String>(mas);

        System.out.println("Уникальные значения и количество повторений:");
        for(String uniqueWord: mySet){
            System.out.printf("Слово: %s; Количество повторений: %s%n",uniqueWord,Collections.frequency(mas,uniqueWord));
        }
    }

}
