package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
    public Connection connect() {
        Connection connect = null;
        try{
            String url ="jdbc:mysql://localhost:3306/cards?user=root&password=root";
            //Class.forName("com.mysql.jdbc.Driver");
           connect = DriverManager.getConnection(url);
            System.out.println("Connected");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return connect;
    }

}
