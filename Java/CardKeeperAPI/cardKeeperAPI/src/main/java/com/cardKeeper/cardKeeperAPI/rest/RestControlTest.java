package com.cardKeeper.cardKeeperAPI.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControlTest {
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }
    @GetMapping("/cardID")
    public String CardIDs(){
        return "Card ID: 0000";
    }
    @GetMapping("/cardCode")
    public String CardCodes(){
        return "Card Code: MP22-22";
    }
    @GetMapping("/cardName")
    public String CardNames(){
        return  "Card name: Nibiru";
    }

}
