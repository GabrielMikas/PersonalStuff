package com.cardKeeper.cardKeeperAPI.rest;

import com.cardKeeper.cardKeeperAPI.cards.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("cards")
public class RestControlCards {
    @Autowired
    private CardRepository repository;

    @PostMapping
    @Transactional
    public void ReceiveCards(@RequestBody CardsPostDTO objCardsDTO){
        repository.save(new Cards(objCardsDTO));
    }
    //This GET returns just the CardName, CardCode, CardQuality, CardsAmount
    @GetMapping
    public List<CardsGetDTO> SendCards(){
        return repository.findAll().stream().map(CardsGetDTO::new).toList();
    }
    @PutMapping
    @Transactional
    public void UpdateCards(@RequestBody @Valid CardsPutDTO cards){
        repository.getReferenceById(cards.id()).Update(cards);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void DeleteCards(@PathVariable Long id){
        repository.deleteById(id);

    }
}
