package com.aca.mtgprice.dao;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;

import java.util.List;

public class CardDaoImpl implements CardDao {

    private static String selectStandardLegal;

    @Override
    public List<Card> getCards() {
        return List.of();
    }

    @Override
    public List<Card> getCardsBySetCode(Code code) {
        return List.of();
    }

    @Override
    public List<Card> getCardsByRarity(Rarity rarity) {
        return List.of();
    }

    @Override
    public List<Card> getCardsById(Integer cardId) {
        return List.of();
    }

    @Override
    public List<Card> getCardsByName(String nameValue) {
        return List.of();
    }

    @Override
    public List<Card> getCardsByCMC(Integer manaValue) {
        return List.of();
    }

    @Override
    public List<Card> getCardsByColor(String colorValue) {
        return List.of();
    }
}
