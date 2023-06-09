package View;

import DTO.CardDTO;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        //main frame

        JFrame Jframe = new JFrame();
        JButton testjb = new JButton("Register");
        testjb.setBounds(50,400,95,30);
        JTextField jt1 = new JTextField("This is jt1(cardName)");
        jt1.setBounds(50,250,150,25);
        JTextField jt2 = new JTextField("This is jt2(cardCode)");
        jt2.setBounds(50,300,150,25);
        JTextField jt3 = new JTextField("This is jt3(cardAmount)");
        jt3.setBounds(50,350,150,25);
        //gets input from text fields and prints them



        Jframe.setSize(400,500);
        Jframe.add(jt1);
        Jframe.add(jt2);
        Jframe.add(jt3);
        Jframe.add(testjb);


        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(jt1.getText());
                System.out.println(jt2.getText());
                System.out.println(jt3.getText());
            }
        });




        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }
}