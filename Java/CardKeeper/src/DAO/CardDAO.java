package DAO;

import DTO.CardDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CardDAO {
    Connection conn;
    PreparedStatement pstm;
    public void registerTest(CardDTO cardDTOobject){
        String sql = "insert into cards (CardName, CardCode, CardQuality, CardsAmount) values (?, ?, ?, ?)";
        conn = new DBconnection().connect();
        String name, code, quality, amount;

        name = cardDTOobject.getCardName();
        code = cardDTOobject.getCardCode();
        quality = cardDTOobject.getCardQual();
        amount = cardDTOobject.getCardNumber();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, code);
            pstm.setString(3, quality);
            pstm.setString(4, amount);
            pstm.execute();
            pstm.close();
            System.out.println("Card registered successfully");
            System.out.println("Card Name:" + name);
            System.out.println("Card code:" + code);
            System.out.println("Card Quality:" + quality);
            System.out.println("Card Amount:" + amount);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema no registerTest:" + e);
        }

    }
    
}
