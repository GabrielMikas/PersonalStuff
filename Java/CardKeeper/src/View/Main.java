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
    static String[] col={"ID", "Name", "Code","Quality", "Amount"};
    static DefaultTableModel model = new DefaultTableModel(null, col);
    //It works like this for some reason so do not touch
    public static void initFrame(){
        CardDTO cardDTOobject = new CardDTO();
        CardDAO cardDAOobject = new CardDAO();


        //Initializing components
        JFrame Jframe = new JFrame();
        JButton testjb = new JButton("Register");
        JButton btnEdit = new JButton("Edit");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JLabel l1 = new JLabel("Card Name");
        JLabel l2 = new JLabel("Card Code");
        JLabel l4 = new JLabel("Card Quality");
        JLabel l3 = new JLabel("Amount of cards");
        JLabel l5 = new JLabel("Card ID");
        JTable jt = new JTable(model);
        JTextField jt1 = new JTextField();
        JTextField jt2 = new JTextField();
        JTextField jt3 = new JTextField();
        JTextField jt4 = new JTextField();
        JTextField jt5 = new JTextField();
        JScrollPane pane = new JScrollPane(jt);


        //Setting component bounds
        pane.setBounds(525,30,400,400);
        l1.setBounds(75,80,150,25);
        l2.setBounds(75,130,150,25);
        l4.setBounds(75,180,150,25);
        l3.setBounds(75,230,150,25);
        l5.setBounds(75,30,150,25);
        jt1.setBounds(75,100,150,25);
        jt2.setBounds(75,150,150,25);
        jt3.setBounds(75,200,150,25);
        jt4.setBounds(75, 250,150,25);
        jt5.setBounds(75,50,150,25);

        testjb.setBounds(50,300,95,30);
        btnEdit.setBounds(50,350,95,30);
        btnUpdate.setBounds(155,300,95,30);
        btnDelete.setBounds(155, 350,95,30);



        jt5.setEditable(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        //Adding stuff to the main frame
        Jframe.setSize(980,800);
        Jframe.add(pane);
        Jframe.add(l1);
        Jframe.add(l2);
        Jframe.add(l3);
        Jframe.add(l4);
        Jframe.add(l5);
        Jframe.add(jt1);
        Jframe.add(jt2);
        Jframe.add(jt3);
        Jframe.add(jt4);
        Jframe.add(jt5);
        Jframe.add(testjb);
        Jframe.add(btnUpdate);
        Jframe.add(btnEdit);
        Jframe.add(btnDelete);

        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jt.getSelectedRow();
                try{
                    jt5.setText(jt.getModel().getValueAt(selectedRow, 0).toString());
                    jt1.setText(jt.getModel().getValueAt(selectedRow, 1).toString());
                    jt2.setText(jt.getModel().getValueAt(selectedRow, 2).toString());
                    jt3.setText(jt.getModel().getValueAt(selectedRow, 3).toString());
                    jt4.setText(jt.getModel().getValueAt(selectedRow, 4).toString());
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                } catch (Exception erro){
                    JOptionPane.showMessageDialog(Jframe, "Please selected a row to edit");
                }

            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int ID =  Integer.parseInt(jt5.getText());
                String name = jt1.getText();
                String code = jt2.getText();
                String quality = jt3.getText();
                String amount = jt4.getText();
                if(name.equals("")||code.equals("")||amount.equals("")||quality.equals("")){
                    JOptionPane.showMessageDialog(Jframe,"Please fill all the fields");
                }
                else{
                    cardDTOobject.setCardID(ID);
                    cardDTOobject.setCardName(name);
                    cardDTOobject.setCardCode(code);
                    cardDTOobject.setCardQual(quality);
                    cardDTOobject.setCardNumber(amount);
                    cardDAOobject.UpdateCard(cardDTOobject);
                    readCards();

            }
        }});
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ID =  Integer.parseInt(jt5.getText());
                if(jt5.getText().equals("")){
                    JOptionPane.showMessageDialog(Jframe, "Please click the Edit button");
                }else{
                    cardDTOobject.setCardID(ID);
                    cardDAOobject.DeleteCard(cardDTOobject);
                    readCards();
                }

            }
        });
        //Action listeners
        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = jt1.getText();
                String code = jt2.getText();
                String quality = jt3.getText();
                String amount = jt4.getText();
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