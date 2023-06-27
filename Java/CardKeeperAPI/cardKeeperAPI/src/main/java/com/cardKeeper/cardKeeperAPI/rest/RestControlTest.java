package com.cardKeeper.cardKeeperAPI.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cards")
public class RestControlTest {

    @PostMapping
    public void ReceiveCards(@RequestBody cardsDTO objCardsDTO){
        System.out.println(objCardsDTO);
    }
/*
* TODO:
*  NEED TO CONFIGURE THE SQL STUFF AND THE OTHER REQUESTS
* */
}
