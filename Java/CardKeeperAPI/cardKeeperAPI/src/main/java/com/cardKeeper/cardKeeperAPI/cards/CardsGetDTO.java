package com.cardKeeper.cardKeeperAPI.cards;

public record CardsGetDTO(Long id, String CardName, String CardCode, String CardQuality, String CardsAmount) {

    public CardsGetDTO(Cards cards){
        this(cards.getCardID(), cards.getCardName(), cards.getCardCode(), cards.getCardQuality(), cards.getCardsAmount());
    }

}
