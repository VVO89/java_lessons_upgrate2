package lesson6;

import javax.print.attribute.Size2DSyntax;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 8081);
            // выводим на экран входящий поток
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String inputString;
            String messageOut = "";
            String message_sc;
            do {
                // для возможности многострочной отправки
                System.out.println("Клиент: ");
                do {
                    Scanner scanner = new Scanner(System.in);
                    message_sc = scanner.nextLine();
                    if (!message_sc.equals("/send")) {
                        messageOut = messageOut.concat(message_sc).concat("\n");
                    }
                } while (!message_sc.equals("/send"));
                out.writeUTF(messageOut);
                out.flush();

                // читаем сообщение от сервера
                System.out.println("Сервер: ");
                System.out.println(in.readUTF());

            } while (!messageOut.equals("/end"));
            socket.close();
        } catch (IOException e) {
            System.out.println("Сервер отключился");
            e.printStackTrace();
        }

    }
}
