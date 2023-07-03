package com.cardKeeper.cardKeeperAPI.cards;

import jakarta.validation.constraints.NotNull;

public record CardsPutDTO(
        @NotNull
        Long id,
        String CardName,
        String CardCode,
        String CardQuality,
        String CardsAmount) {

}
