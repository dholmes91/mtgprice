package com.aca.mtgprice.model;

import java.util.List;

public class Card {
    private String name;
    private Type type;
    private Rarity rarity;
    private Code code;
    private double price1;
    private double price2;
    private double priceDiff;
    private Integer cardId;
    private Integer CMC;
    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCMC() {
        return CMC;
    }

    public void setCMC(Integer CMC) {
        this.CMC = CMC;
    }

    public double getPriceDiff() {
        return priceDiff;
    }

    public void setPriceDiff(double priceDiff) {
        this.priceDiff = priceDiff;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }
}
