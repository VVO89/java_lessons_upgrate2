package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {

    private HashMap<String, ArrayList> telDirectory = new HashMap<>();

    public void add(Person persons){
        telDirectory.put(persons.getFamily(),persons.getArrayNumber());
    }

    public void get(String newFamily){

        ArrayList<String> search_key = telDirectory.get(newFamily);

        if (search_key == null){
            return;
        }

        for (int i = 0; i < search_key.size(); i++) {
            System.out.printf("Фамилия: %s; Телефонный номер: %s%n",newFamily,search_key.get(i));
        }

    }
}
