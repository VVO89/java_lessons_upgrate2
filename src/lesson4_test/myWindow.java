package lesson4_test;

import javax.swing.*;
import java.awt.*;

public class myWindow extends JFrame {

    public myWindow(){
        setTitle("Мое первое окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,300,300);
        // добавляем кнопки
        JButton[] jbs = new JButton[5];
        // заполним наименование
        for (int i = 0; i < 5; i++) {
            jbs[i] = new JButton("#"+i);
        }
        // выбор компоновщика элементов
        setLayout(new BorderLayout());
        add(jbs[0],BorderLayout.EAST);
        add(jbs[1],BorderLayout.WEST);
        add(jbs[2],BorderLayout.SOUTH);
        add(jbs[3],BorderLayout.NORTH);
        add(jbs[4],BorderLayout.CENTER);

        setVisible(true);
    }
}
