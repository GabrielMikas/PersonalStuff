package View;

import DAO.CardDAO;
import DAO.DBconnection;
import DTO.CardDTO;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {


    //It works like this for some reason so do not touch
    static String data[][]={{"ID", "Name", "Code","Quality", "Amount"}};
    static String col[]={"ID", "Name", "Code","Quality", "Amount"};
    static DefaultTableModel model = new DefaultTableModel(data, col);
    //It works like this for some reason so do not touch
    public static void initFrame(){
        CardDTO cardDTOobject = new CardDTO();
        CardDAO cardDAOobject = new CardDAO();


        //Initializing components
        JFrame Jframe = new JFrame();
        JButton testjb = new JButton("Register");
        JButton readTest = new JButton("Read");
        JLabel l1 = new JLabel("Card Name");
        JLabel l2 = new JLabel("Card Code");
        JLabel l4 = new JLabel("Card Quality");
        JLabel l3 = new JLabel("Amount of cards");
        JTable jt = new JTable(model);
        JTextField jt1 = new JTextField();
        JTextField jt2 = new JTextField();
        JTextField jt3 = new JTextField();
        JTextField jt4 = new JTextField();

        //Setting component bounds
        jt.setBounds(225,30,400,400);
        l1.setBounds(50,30,150,25);
        l2.setBounds(50,80,150,25);
        l3.setBounds(50,130,150,25);
        l4.setBounds(50,180,150,25);
        jt1.setBounds(50,50,150,25);
        jt2.setBounds(50,100,150,25);
        jt3.setBounds(50,150,150,25);
        jt4.setBounds(50, 200,150,25);
        testjb.setBounds(50,250,95,30);
        readTest.setBounds(50,290,95,30);

        //Adding stuff to the main frame
        Jframe.setSize(800,500);
        Jframe.add(jt);
        Jframe.add(l1);
        Jframe.add(l2);
        Jframe.add(l3);
        Jframe.add(l4);
        Jframe.add(jt1);
        Jframe.add(jt2);
        Jframe.add(jt3);
        Jframe.add(jt4);
        Jframe.add(testjb);
        Jframe.add(readTest);


        //Action listeners
        readTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<CardDTO> cardlist = cardDAOobject.readCardInfo();
                model.setRowCount(0);
                for(int num = 0; cardlist.size() > num; num++){
                    model.addRow(new Object[]{
                            cardlist.get(num).getCardID(),
                            cardlist.get(num).getCardName(),
                            cardlist.get(num).getCardCode(),
                            cardlist.get(num).getCardQual(),
                            cardlist.get(num).getCardNumber()
                    });
                }

            }
        });
        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {



                String name = jt1.getText();
                String code = jt2.getText();
                String quality = jt4.getText();
                String amount = jt3.getText();
                if(name.equals("")||code.equals("")||amount.equals("")||quality.equals("")){
                    JOptionPane.showMessageDialog(Jframe,"Please fill all the fields");
                }
                else{
                    cardDTOobject.setCardName(name);
                    cardDTOobject.setCardCode(code);
                    cardDTOobject.setCardQual(quality);
                    cardDTOobject.setCardNumber(amount);

                    cardDAOobject.registerTest(cardDTOobject);


                    //Adds the registered card to the table

                    readCards();


                    JOptionPane.showMessageDialog(Jframe,"Card registered successfully");
                }


            }
        });


        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }
    public static void readCards(){
        CardDAO cardDAOobject = new CardDAO();
        ArrayList<CardDTO> cardlist = cardDAOobject.readCardInfo();
        model.setRowCount(0);
        for(int num = 0; cardlist.size() > num; num++){
            model.addRow(new Object[]{
                    cardlist.get(num).getCardID(),
                    cardlist.get(num).getCardName(),
                    cardlist.get(num).getCardCode(),
                    cardlist.get(num).getCardQual(),
                    cardlist.get(num).getCardNumber()
            });
        }

    }
    public static void main(String[] args) {
        initFrame();
        readCards();
    }
}