package DTO;

import com.sun.jdi.PrimitiveValue;

public class CardDTO {
    private String cardCode;
   private String cardName;
    private String cardNumber;
    private String cardQual;
    private int cardID;

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardQual() {
        return cardQual;
    }

    public void setCardQual(String cardQual) {
        this.cardQual = cardQual;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String  getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
