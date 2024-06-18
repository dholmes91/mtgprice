package com.aca.mtgprice.dao;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;

import java.util.List;

public interface CardDao {

     List<Card> getCards();
     List<Card> getCardsBySetCode(Code code);

}
