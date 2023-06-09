package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGroup {
    public JButton testJB(){
        JButton testjb = new JButton("Register");
        testjb.setBounds(50,400,95,30);
        //gets input from text fields and prints them
        testjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                System.out.println();
                System.out.println();
            }
        });
        return testjb;
    }

}
