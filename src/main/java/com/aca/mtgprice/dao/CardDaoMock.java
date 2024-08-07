package com.aca.mtgprice.dao;

import java.util.ArrayList;
import java.util.List;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;
import com.aca.mtgprice.model.Type;

public class CardDaoMock implements CardDao {

    private static final List<Card> cards = new ArrayList<>();

    static {
        Card dillo = new Card();
        dillo.setName("Armored Armadillo");
        dillo.setRarity(Rarity.Common);
        dillo.setPrice1(1.03);
        dillo.setPrice2(1.07);
        dillo.setType(Type.Creature);
        dillo.setCode(Code.OTJ);
        dillo.setCardId(1);
        dillo.setCMC(1);
        dillo.setColor("W");

        Card murder = new Card();
        murder.setName("Murder");
        murder.setRarity(Rarity.Common);
        murder.setPrice1(.23);
        murder.setPrice2(.12);
        murder.setType(Type.Instant);
        murder.setCode(Code.MKM);
        murder.setCardId(2);
        murder.setCMC(3);
        murder.setColor("B");

        Card spyglass = new Card();
        spyglass.setName("Sorcerous Spyglass");
        spyglass.setRarity(Rarity.Uncommon);
        spyglass.setPrice1(.65);
        spyglass.setPrice2(.72);
        spyglass.setType(Type.Artifact);
        spyglass.setCode(Code.LCI);
        spyglass.setCardId(3);
        spyglass.setCMC(2);
        spyglass.setColor("");

        cards.add(dillo);
        cards.add(murder);
        cards.add(spyglass);

    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public List<Card> getTopMovers() {
        return List.of();
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

    @Override
    public List<Card> getCardsByRarity(Rarity rarity) {
        List<Card> myCards = new ArrayList<>();
        for (Card card : CardDaoMock.cards) {
            if (card.getRarity().equals(rarity)) {
                myCards.add(card);
            }
        }
        return myCards;
    }

    @Override
    public List<Card> getCardsById(Integer cardId) {
        List<Card> myCards = new ArrayList<>();
        for (Card card : CardDaoMock.cards) {
            if (card.getCardId().intValue() == cardId.intValue()) {
                myCards.add(card);
            }
        }
        return myCards;
    }

    @Override
    public List<Card> getCardsByName(String nameValue) {
        List<Card> myCards = new ArrayList<>();
        for (Card card : CardDaoMock.cards) {
            if (card.getName().toLowerCase().contains(nameValue.toLowerCase())) {
                myCards.add(card);
            }
        }
        return myCards;
    }

    @Override
    public List<Card> getCardsByCMC(Integer manaValue) {
        List<Card> myCards = new ArrayList<>();
        for (Card card : CardDaoMock.cards) {
            if (card.getCMC().intValue() == manaValue.intValue()) {
                myCards.add(card);
            }
        }
        return myCards;
    }

    @Override
    public List<Card> getCardsByColor(String colorValue) {
        List<Card> myCards = new ArrayList<>();
        for (Card card : CardDaoMock.cards) {
            if (card.getColor().toLowerCase().contains(colorValue.toLowerCase())) {
                myCards.add(card);
            }
        }
        return myCards;
    }

    @Override
    public List<Card> getCardsByType(Type type) {
        return List.of();
    }

    @Override
    public List<Card> getPurchaseUrl(String urlValue) {

        throw new UnsupportedOperationException("Unimplemented method 'getPurchaseUrl'");
    }
}
