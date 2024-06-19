package com.aca.mtgprice.dao;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;

import java.util.List;

public interface CardDao {

     List<Card> getCards();
     List<Card> getCardsBySetCode(Code code);

     List<Card> getCardsByRarity(Rarity rarity);

     List<Card> getCardsById(Integer cardId);

     List<Card> getCardsByName(String nameValue);

     List<Card> getCardsByCMC(Integer manaValue);

}
