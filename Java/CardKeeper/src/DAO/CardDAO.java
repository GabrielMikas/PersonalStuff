package DAO;

import DTO.CardDTO;

import javax.swing.*;

public class CardDAO {
    public void registerTest(CardDTO cardDTOobject){
        String name, code, amount;

        name = cardDTOobject.getCardName();
        code = cardDTOobject.getCardCode();
        amount = cardDTOobject.getCardNumber();

        System.out.println("Card registered successfully");
        System.out.println("Card Name:" + name);
        System.out.println("Card code:" + code);
        System.out.println("Card Amount:" + amount);
    }
}
