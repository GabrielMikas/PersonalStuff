import DTO.CardDTO;

public class Main {
    public static void printCard(){
        CardDTO card = new CardDTO();
        card.setCardCode("00-00");
        card.setCardName("White eyes blue dragon");
        card.setCardNumber(3);
        System.out.println("Card code: " + card.getCardCode());
        System.out.println("Card name: " + card.getCardName());
        System.out.println("Number of cards: " + card.getCardNumber());
    }
    public static void main(String[] args) {
        printCard();

    }
}