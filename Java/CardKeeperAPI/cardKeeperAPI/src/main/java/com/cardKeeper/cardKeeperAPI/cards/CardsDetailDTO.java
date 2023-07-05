package com.cardKeeper.cardKeeperAPI.cards;

public record CardsDetailDTO(Long id, String CardName, String CardCode, String CardQuality, String CardsAmount) {

    public CardsDetailDTO(Cards cards){
        this(cards.getCardID(), cards.getCardName(), cards.getCardCode(), cards.getCardQuality(), cards.getCardsAmount());
    }

}
