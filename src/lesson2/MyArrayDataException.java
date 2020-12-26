package lesson2;

import java.util.ArrayList;

public class MyArrayDataException extends NumberFormatException {

    private ArrayList messageList;
    private int masSum;

    // конструктор
    public MyArrayDataException(ArrayList messageList, int masSum) {
        //super(message);
        this.messageList = messageList;
        this.masSum = masSum;
    }

    public ArrayList getMessageList() {
        return messageList;
    }

    public int getMasSum() {
        return masSum;
    }
}
