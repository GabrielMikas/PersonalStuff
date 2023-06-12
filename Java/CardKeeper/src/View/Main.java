package View;

import DAO.CardDAO;
import DTO.CardDTO;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
       //Default table data
        String data[][]={{"ID", "Name", "Code", "Amount"}};
        String col[]={"ID", "Name", "Code", "Amount"};

        //Initializing components
        DefaultTableModel model = new DefaultTableModel(data, col);
        JFrame Jframe = new JFrame();
        JButton testjb = new JButton("Register");
        JLabel l1 = new JLabel("Card Name");
        JLabel l2 = new JLabel("Card Code");
        JLabel l3 = new JLabel("Amount of cards");
        JTable jt = new JTable(model);
        JTextField jt1 = new JTextField();
        JTextField jt2 = new JTextField();
        JTextField jt3 = new JTextField();

        //Setting component bounds
        jt.setBounds(225,30,400,400);
        l1.setBounds(50,30,150,25);
        l2.setBounds(50,80,150,25);
        l3.setBounds(50,130,150,25);
        jt1.setBounds(50,50,150,25);
        jt2.setBounds(50,100,150,25);
        jt3.setBounds(50,150,150,25);
        testjb.setBounds(50,200,95,30);

        //Adding stuff to the main frame
        Jframe.setSize(800,500);
        Jframe.add(jt);
        Jframe.add(l1);
        Jframe.add(l2);
        Jframe.add(l3);
        Jframe.add(jt1);
        Jframe.add(jt2);
        Jframe.add(jt3);
        Jframe.add(testjb);

        //Action listeners
        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                CardDTO cardDTOobject = new CardDTO();
                CardDAO cardDAOobject = new CardDAO();

                String name = jt1.getText();
                String code = jt2.getText();
                String amount = jt3.getText();
                if(name.equals("")||code.equals("")||amount.equals("")){
                    JOptionPane.showMessageDialog(Jframe,"Please fill all the fields");
                }
                else{
                    cardDTOobject.setCardName(name);
                    cardDTOobject.setCardCode(code);
                    cardDTOobject.setCardNumber(amount);

                    cardDAOobject.registerTest(cardDTOobject);


                    //Adds the registered card to the table
                    String data[] = {"ID", name, code, amount};
                    model.addRow(data);

                    JOptionPane.showMessageDialog(Jframe,"Card registered successfully");
                }


            }
        });




        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }
}