package com.aca.mtgprice.service;

import java.util.List;

import com.aca.mtgprice.dao.CardDao;
import com.aca.mtgprice.dao.CardDaoImpl;
import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;
import com.aca.mtgprice.model.Type;

public class CardService {

    private CardDao cardDao = new CardDaoImpl();

    public List<Card> getCardsByType(Type type) {
        return cardDao.getCardsByType(type);
    }

    public List<Card> getTopMovers() {
        return cardDao.getTopMovers();
    }

    public List<Card> getCards() {
        return cardDao.getCards();
    }

    public List<Card> getCardsBySetCode(Code code) {
        return cardDao.getCardsBySetCode(code);
    }

    public List<Card> getCardsByRarity(Rarity rarity) {
        return cardDao.getCardsByRarity(rarity);
    }

    public List<Card> getCardsById(Integer cardId) {
        return cardDao.getCardsById(cardId);
    }

    public List<Card> getCardsByName(String nameValue) {
        return cardDao.getCardsByName(nameValue);
    }

    public List<Card> getCardsByCMC(Integer manaValue) {
        return cardDao.getCardsByCMC(manaValue);
    }

    public List<Card> getCardsByColor(String colorValue) {
        return cardDao.getCardsByColor(colorValue);
    }


}
