package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {

    private String family;
    private ArrayList<String> arrayNumber = new ArrayList<>();

    public Person(String family) {
        this.family = family;
    }

    public void add(String newNumber) {
        arrayNumber.add(newNumber);
    }

    public String getFamily() {
        return family;
    }

    public ArrayList<String> getArrayNumber() {
        return arrayNumber;
    }

}
