package com.aca.mtgprice.dao;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Type;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;

import java.util.ArrayList;
import java.util.List;

public class CardDaoMock implements CardDao {

    private static List<Card> cards = new ArrayList<>();

    static {
        Card dillo = new Card();
        dillo.setName("Armored Armadillo");
        dillo.setRarity(Rarity.C);
        dillo.setPrice(1.03);
        dillo.setType(Type.Creature);
        dillo.setCode(Code.OTJ);

        Card murder = new Card();
        murder.setName("Murder");
        murder.setRarity(Rarity.C);
        murder.setPrice(.23);
        murder.setType(Type.Instant);
        murder.setCode(Code.MKM);

        Card spyglass = new Card();
        spyglass.setName("Sorcerous Spyglass");
        spyglass.setRarity(Rarity.UC);
        spyglass.setPrice(.65);
        spyglass.setType(Type.Artifact);
        spyglass.setCode(Code.LCI);

        cards.add(dillo);
        cards.add(murder);
        cards.add(spyglass);

    }


    @Override
    public List<Card> getCards() {
        List<Card> myCards = new ArrayList<>(cards);
        return myCards;
    }

    @Override
    public List<Card> getCardsBySetCode(Code code) {
        List<Card> myCards = new ArrayList<>();
        for (Card card : CardDaoMock.cards) {
            if (card.getCode().equals(code)) {
                myCards.add(card);
            }
        }
        return myCards;
    }
}
