package lesson2;

import java.util.ArrayList;

public class Main extends Exception{

    public static void main(String[] args) throws MyArraySizeException,MyArrayDataException {

        // заполним массив, специально, чтобы вышло исключение
        String[][] mas = new String[3][3];

        mas[0][0] = "1";
        mas[0][1] = "2";
        mas[1][0] = "0";
        mas[1][1] = "0";
        mas[2][0] = "0";
        mas[2][1] = "0";

        try {
            doAction(mas);
        }catch (MyArraySizeException ex){
            System.out.println(ex.getMessage());
        }catch (MyArrayDataException ex){
            ArrayList<String> errors = ex.getMessageList();

            if (errors.size() > 0) {
                for (int i = 0; i < errors.size(); i++) {
                    System.out.println(errors.get(i));
                }
            }

            System.out.println();
            System.out.printf("Сумма элементов массива: %d", ex.getMasSum());

        }
    }

    public static void doAction(String[][] masStr) throws MyArraySizeException,NumberFormatException{

        // безразмерный массив для накопления ошибок преобразования в INT
        ArrayList<String> errors = new ArrayList<>();
        // проверка размерности массива
        if (masStr.length != 3){
            throw new MyArraySizeException("Указан некорректный размер массива");
        }
        // накопление суммы элементов массива
        int masSum = 0;

        for (int i = 0; i < masStr.length; i++) {
            for (int j = 0; j < masStr.length; j++) {

                try {
                    int mas_i = Integer.parseInt(masStr[i][j]);
                    masSum+= mas_i;
                }catch (NumberFormatException ex){
                    String str_i = Integer.toString(i);
                    String str_j = Integer.toString(j);
                    String message = String.format("В ячейке [%1$s][%2$s] лежит символ или текст вместо числа",str_i,str_j);
                    // добавляем в список ошибок
                    errors.add(message);
                }
            }
        }

        if (errors.size() > 0) {
            throw new MyArrayDataException(errors,masSum);
        }

        System.out.println();
        System.out.printf("Сумма элементов массива: %d", masSum);

    }

}
