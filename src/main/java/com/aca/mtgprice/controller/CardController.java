package com.aca.mtgprice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;
import com.aca.mtgprice.model.Type;
import com.aca.mtgprice.service.CardService;

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
        return service.getCardsByName(nameValue);
    }

    @RequestMapping(value = "/rarity/{rarityValue}", method = RequestMethod.GET)
    public List<Card> getCardsByRarity(@PathVariable Rarity rarityValue) {
        return service.getCardsByRarity(rarityValue);
    }

    @RequestMapping(value = "/set/{codeValue}", method = RequestMethod.GET)
    public List<Card> getCardsBySetCode(@PathVariable Code codeValue) {
        return service.getCardsBySetCode(codeValue);
    }

    @RequestMapping(value = "/id/{cardIdValue}", method = RequestMethod.GET)
    public List<Card> getCardsById(@PathVariable Integer cardIdValue) {
        return service.getCardsById(cardIdValue);

    }

    @RequestMapping(value = "/cmc/{manaValue}", method = RequestMethod.GET)
    public List<Card> getCardsByCMC(@PathVariable Integer manaValue) {
        return service.getCardsByCMC(manaValue);

    }

    @RequestMapping(value = "/color/{colorValue}", method = RequestMethod.GET)
    public List<Card> getCardsByColor(@PathVariable String colorValue) {
        return service.getCardsByColor(colorValue);

    }

    @RequestMapping(value = "/type/{typeValue}", method = RequestMethod.GET)
    public List<Card> getCardsByType(@PathVariable Type typeValue) {
        return service.getCardsByType(typeValue);

    }

    @RequestMapping(value = "/topMovers", method = RequestMethod.GET)
    public List<Card> getTopMovers() {
        return service.getTopMovers();

    }
}