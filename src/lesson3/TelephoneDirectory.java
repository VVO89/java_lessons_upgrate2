package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {

    private static HashMap<String, ArrayList> telDirectory = new HashMap<>();
    private String newFamily;

    public void setNewFamily(String newFamily) {
        this.newFamily = newFamily;
    }

    public static void add(Person persons){
        telDirectory.put(persons.getFamily(),persons.getArrayNumber());
    }

    public static void get(String nFamily){

        ArrayList<String> search_key = telDirectory.get(nFamily);

        for (int i = 0; i < search_key.size(); i++) {
            System.out.printf("Фамилия: %s; Телефонный номер: %s%n",nFamily,search_key.get(i));
        }

    }
}
