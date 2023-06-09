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
        //gets input from text fields and prints them

        TextFieldGroup tfg = new TextFieldGroup();

        Jframe.setSize(400,500);
        Jframe.add(testjb);
        Jframe.add(tfg.cardNameInput());
        Jframe.add(tfg.cardAmountInput());
        Jframe.add(tfg.cardCodeInput());

        JTextField cardNameField = tfg.cardNameInput();
        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(cardNameField.getText());
                System.out.println(tfg.cardCodeInput().getText());
                System.out.println(tfg.cardAmountInput().getText());
            }
        });




        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }
}