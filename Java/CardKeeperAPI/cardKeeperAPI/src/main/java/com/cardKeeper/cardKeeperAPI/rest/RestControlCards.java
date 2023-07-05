package com.cardKeeper.cardKeeperAPI.rest;

import com.cardKeeper.cardKeeperAPI.cards.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("cards")
public class RestControlCards {
    //Handles injection
    @Autowired
    private CardRepository repository;

    //Handles the POST request
    @PostMapping
    @Transactional
    public ResponseEntity ReceiveCards(@RequestBody CardsPostDTO objCardsDTO, UriComponentsBuilder uriBuilder){
        //Instantiates the POST dto through the Cards constructor
        //The Cards class is the blueprint for the JPA entity
        var cards = new Cards(objCardsDTO);
        //Adds to the database through the JPA entity
        repository.save(cards);
        //Deals with creating the URI for future deployment
        //The argument {id} is given by the posted cards' id in the database
        var uri = uriBuilder.path("/cards/{id}").buildAndExpand(cards.getCardID()).toUri();
        //Returns 201 CREATED + the created element + the header with the ID
        return ResponseEntity.created(uri).body(new CardsDetailDTO(cards));
    }

    //Handles GET when given an {id} as argument on the request
    @GetMapping("/{id}")
    public ResponseEntity DetailCards(@PathVariable Long id){
        //Instantiates a card according to the ID given on the argument(@PathVariable)
        var cards = repository.getReferenceById(id);
        //Returns the instantiated card, on the body, + 200
        return ResponseEntity.ok(new CardsDetailDTO(cards));
    }

    //This GET returns just the CardName, CardCode, CardQuality, CardsAmount of all cards
    @GetMapping
    public ResponseEntity<List<CardsGetDTO>> SendCards(){
        //Instantiates all cards present on the db and turns them into a list
        var cards = repository.findAll().stream().map(CardsGetDTO::new).toList();
        //returns the list + 200
        return ResponseEntity.ok(cards);
    }

    //Handles the PUT request
    @PutMapping
    @Transactional
    public ResponseEntity UpdateCards(@RequestBody @Valid CardsPutDTO cards){
        //Instantiates a card according to the given ID in the body(@RequestBody)
       var card = repository.getReferenceById(cards.id());
       //Updates the appropriate card with info given on the body of the request
       card.Update(cards);
       //Returns 200 + the updated info
        return ResponseEntity.ok(new CardsDetailDTO(card));
    }

    //Handles DELETE when given an {id} as argument on the request
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteCards(@PathVariable Long id){
        //Deletes a card according to the ID given on the argument(@PathVariable)
        repository.deleteById(id);
        //Returns 204
        return ResponseEntity.noContent().build();
    }


}
