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
        // реализовать можно было через отдельный класс Person с хранением фамилии и номеров телефонов
        // но смысл от этого не меняется
        // добавим тестовые данные
        // 1 фамилия
        String surname1 = "Вдовенко";
        ArrayList<String> surnameTel1 = new ArrayList<>();
        surnameTel1.add("12345");
        surnameTel1.add("123456");

        // 2 фамилия
        String surname2 = "Иванов";
        ArrayList<String> surnameTel2 = new ArrayList<>();
        surnameTel2.add("7653");

        // 3 фамилия
        String surname3 = "Петров";
        ArrayList<String> surnameTel3 = new ArrayList<>();
        surnameTel3.add("1");
        surnameTel3.add("2");

        TelephoneDirectory tel = new TelephoneDirectory();

        // добавляем в телефонный справочник
        tel.add(surname1,surnameTel1);
        tel.add(surname2,surnameTel2);
        tel.add(surname3,surnameTel3);

        // получаем из справочника номера телефонов
        tel.get("Вдовенко");

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
