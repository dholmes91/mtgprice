package com.aca.mtgprice.service;

import java.util.List;

import com.aca.mtgprice.dao.CardDao;
import com.aca.mtgprice.dao.CardDaoMock;
import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;

public class CardService {

    private CardDao cardDao = new CardDaoMock();

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


}
