package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        Socket socket = null;

        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("Сервер запущен, ожидаем подключения клиента");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            // создаем входящие и исходящие потоки
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String inputString = null;
            do{
                // получаем сообщение от клиента
                inputString = in.readUTF();
                System.out.println("Клиент: ");
                System.out.println(inputString);
                // отправим сообщение клиенту
                // реализуем алгоритм многострочной отправки
                String messageOut = "";
                String messageSc;
                do{
                    Scanner scanner = new Scanner(System.in);
                    messageSc = scanner.nextLine();
                    if (!messageSc.equals("/send")) {
                        messageOut = messageOut.concat(messageSc).concat("\n");
                    }
                }while (!messageSc.equals("/send"));

                out.writeUTF(messageOut);
                System.out.println("Клиент: ");

            }while (!inputString.equals("/end"));

        } catch (IOException e) {
            System.out.println("Клиент отключился");
            //e.printStackTrace();
        }

    }

}
