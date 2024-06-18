package com.aca.mtgprice.controller;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;
import com.aca.mtgprice.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/cards", produces = "application/json")
@CrossOrigin("http://127.0.0.1:5500")


public class CardController {
    private CardService service = new CardService();

    @RequestMapping(method = RequestMethod.GET)
    public List<Card> getCards() {
        return service.getCards();
    }

    @RequestMapping(value = "/name/{nameValue}", method = RequestMethod.GET)
    public List<Card> getCardsByName(@PathVariable String nameValue) {
        return service.getCards();
    }

    @RequestMapping(value = "/rarity/{rarityValue}", method = RequestMethod.GET)
    public List<Card> getCardsByRarity(@PathVariable Rarity rarityValue) {
        return service.getCardsByRarity(rarityValue);
    }

    @RequestMapping(value = "/set/{codeValue}", method = RequestMethod.GET)
    public List<Card> getCardsBySetCode(@PathVariable Code codeValue) {
        return service.getCardsBySetCode(codeValue);
    }

}
