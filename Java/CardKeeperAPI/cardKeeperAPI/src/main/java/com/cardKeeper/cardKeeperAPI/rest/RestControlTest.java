package com.cardKeeper.cardKeeperAPI.rest;

import com.cardKeeper.cardKeeperAPI.cards.CardRepository;
import com.cardKeeper.cardKeeperAPI.cards.Cards;
import com.cardKeeper.cardKeeperAPI.cards.cardsDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class RestControlTest {
    @Autowired
    private CardRepository repository;
    @PostMapping
    @Transactional
    public void ReceiveCards(@RequestBody cardsDTO objCardsDTO){
        repository.save(new Cards(objCardsDTO));
    }
    @GetMapping
    public List<Cards> SendCards(){
        return repository.findAll();
    }

}
