package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {

    private HashMap<String, ArrayList> telDirectory = new HashMap<>();

    public void add(String surname, ArrayList<String> arrayNumber){
        telDirectory.put(surname,arrayNumber);
    }

    public void get(String surname){

        ArrayList<String> search_key = telDirectory.get(surname);

        if (search_key == null){
            return;
        }

        for (int i = 0; i < search_key.size(); i++) {
            System.out.printf("Фамилия: %s; Телефонный номер: %s%n",surname,search_key.get(i));
        }

    }
}
