package View;

import DAO.CardDAO;
import DTO.CardDTO;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame Jframe = new JFrame();
        JButton testjb = new JButton("Register");
        JTextField jt1 = new JTextField("This is jt1(cardName)");
        JTextField jt2 = new JTextField("This is jt2(cardCode)");
        JTextField jt3 = new JTextField("This is jt3(cardAmount)");



        jt1.setBounds(50,250,150,25);
        jt2.setBounds(50,300,150,25);
        jt3.setBounds(50,350,150,25);
        testjb.setBounds(50,400,95,30);


        Jframe.setSize(400,500);
        Jframe.add(jt1);
        Jframe.add(jt2);
        Jframe.add(jt3);
        Jframe.add(testjb);


        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardDTO cardDTOobject = new CardDTO();
                CardDAO cardDAOobject = new CardDAO();

                String name = jt1.getText();
                String code = jt2.getText();
                String amount = jt3.getText();

                cardDTOobject.setCardName(name);
                cardDTOobject.setCardCode(code);
                cardDTOobject.setCardNumber(amount);

                cardDAOobject.registerTest(cardDTOobject);

            }
        });




        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }
}