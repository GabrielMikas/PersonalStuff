package View;

import DTO.CardDTO;

import javax.swing.*;

public class Main {

    public static void printCard(){
        CardDTO card = new CardDTO();
        card.setCardCode("00-00");
        card.setCardName("White eyes blue dragon");
        card.setCardNumber(3);
        System.out.println("Card code: " + card.getCardCode());
        System.out.println("Card name: " + card.getCardName());
        System.out.println("Number of cards: " + card.getCardNumber());
        System.out.println("Oi");
    }
    public static void main(String[] args) {
        printCard();
        //main frame
        JFrame Jframe = new JFrame();
        //Testbutton
        ButtonGroup teste = new ButtonGroup();
        //TextFielGroup
        TextFieldGroup tfg = new TextFieldGroup();
        
        Jframe.setSize(400,500);
        Jframe.add(teste.testJB());
        Jframe.add(tfg.cardNameInput());
        Jframe.add(tfg.cardAmountInput());
        Jframe.add(tfg.cardCodeInput());
        Jframe.setLayout(null);
        Jframe.setVisible(true);

    }
}