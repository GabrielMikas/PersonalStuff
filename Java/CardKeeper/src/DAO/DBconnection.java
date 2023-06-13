package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
    public Connection connect() {
        Connection connect = null;
        try{
            Class.forName("org.sqlite.JDBC");
           connect = DriverManager.getConnection("jdbc:sqlite:cardDB.db");
            System.out.println("Connected");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return connect;
    }

}
