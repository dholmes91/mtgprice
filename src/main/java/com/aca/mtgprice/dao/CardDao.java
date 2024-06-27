package com.aca.mtgprice.dao;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;
import com.aca.mtgprice.model.Type;

import java.util.List;

public interface CardDao {

     List<Card> getCards();

     List<Card> getTopMovers();

     List<Card> getCardsBySetCode(Code code);

     List<Card> getCardsByRarity(Rarity rarity);

     List<Card> getCardsById(Integer cardIdValue);

     List<Card> getCardsByName(String nameValue);

     List<Card> getCardsByCMC(Integer manaValue);

     List<Card> getCardsByColor(String colorValue);

     List<Card> getCardsByType(Type type);

     List<Card> getPurchaseUrl(String urlValue);

}
