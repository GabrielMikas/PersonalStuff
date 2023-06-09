package View;

import javax.swing.*;


public class TextFieldGroup {
    public JTextField cardNameInput(){
        JTextField jt1 = new JTextField("This is jt1(cardName)");
        jt1.setBounds(50,250,150,25);
        return jt1;
    }
    public JTextField cardCodeInput(){
        JTextField jt2 = new JTextField("This is jt2(cardCode)");
        jt2.setBounds(50,300,150,25);
        return jt2;
    }
    public JTextField cardAmountInput(){
        JTextField jt3 = new JTextField("This is jt3(cardAmount)");
        jt3.setBounds(50,350,150,25);
        return jt3;
    }

}
