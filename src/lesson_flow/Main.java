package lesson_flow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    private static String PATH = "D://JAVA база/TEXT.txt";
    private static String PATH_COPY = "D://JAVA база/TEXT_COPY.txt";

    public static void main(String[] args) {

        readFile();
        copyFile();
    }

    private static void readFile() {

        int i;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // читаем файл
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //закрываем файл
            try{
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile() {

        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // копирование файла
        try {
            // попытка открытия файла
            fin = new FileInputStream(PATH);
            fout = new FileOutputStream(PATH_COPY);

            // читаем файл
            do{
                i = fin.read();
                if (i!= -1){
                    fout.write(i);
                }
            }while (i!=-1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(fin!=null){
                    fin.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии входного файла");
            }
            try{
                if(fout!=null){
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии выходного файла");
            }
        }
    }
}
