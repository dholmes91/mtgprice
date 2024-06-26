package com.aca.mtgprice.dao;

import com.aca.mtgprice.model.Card;
import com.aca.mtgprice.model.Code;
import com.aca.mtgprice.model.Rarity;
import com.aca.mtgprice.model.Type;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CardDaoImpl implements CardDao {

    private static final String SELECT_ALL_CARDS = "SELECT " +
            "c.name AS name, " +
            "c.id AS id, " +
            "c.rarity AS rarity, " +
            "c.colors AS colors, " +
            "c.type AS type, " +
            "c.manaValue AS manaValue, " +
            "c.setCode AS setCode, " +
            "cp1.vendor AS vendor, " +
            "cp1.price_type AS price_type, " +
            "cp1.price_date AS price_date1, " +
            "cp1.price AS price1, " +
            "cp2.price_date AS price_date2, " +
            "cp2.price AS price2, " +
            "cp1.currency AS currency, " +
            "cp2.price - cp1.price AS price_difference, " +
            "cpu.tcgplayer AS purchase_url " +
            "FROM " +
            "    cards c " +
            "JOIN " +
            "   cardpurchaseurls cpu ON c.uuid = cpu.uuid " +
            "JOIN " +
            "    cardprices cp1 ON c.uuid = cp1.uuid " +
            "JOIN " +
            "    cardprices cp2 ON cp1.uuid = cp2.uuid " +
            "    AND cp1.vendor = cp2.vendor " +
            "    AND cp1.price_type = cp2.price_type " +
            "    AND cp1.currency = cp2.currency " +
            "JOIN " +
            "    cardlegalities cl ON cp1.uuid = cl.uuid " +
            "WHERE " +
            "setCode IN ('MID', 'VOW', 'NEO', 'SNC', 'DMU', 'BRO', 'ONE', 'MOM', 'MAT', 'WOE', 'WOT', 'LCI', 'MKM', 'OTJ', 'BIG', 'OTP') "
            +
            "    AND cp1.price_date = '2024-06-11' " +
            "    AND cp2.price_date = '2024-06-17' " +
            "    AND cl.standard = 'Legal' " +
            "    AND cp1.vendor = 'tcgplayer' " +
            "    AND cp1.price_type = 'retail_normal' " +
            "    AND cp1.currency = 'USD' " +
            "ORDER BY " +
            "    price_difference DESC";

    private static final String SELECT_TOP_MOVERS =

            "(" +
                    "    SELECT " +
                    "        DISTINCT c.name AS name, " +
                    "        c.id AS id, " +
                    "        c.rarity AS rarity, " +
                    "        c.colors AS colors, " +
                    "        c.type AS type, " +
                    "        c.setCode AS setCode, " +
                    "        c.manaValue AS manaValue, " +
                    "        cp1.vendor AS vendor, " +
                    "        cp1.price_type AS price_type, " +
                    "        cp1.price_date AS price_date1, " +
                    "        cp1.price AS price1, " +
                    "        cp2.price_date AS price_date2, " +
                    "        cp2.price AS price2, " +
                    "        cp1.currency AS currency, " +
                    "        cpu.tcgplayer AS purchase_url, " +
                    "        cp2.price - cp1.price AS price_difference " +
                    "    FROM " +
                    "        cards c " +
                    "    JOIN " +
                    "        cardprices cp1 ON c.uuid = cp1.uuid " +
                    "    JOIN " +
                    "        cardprices cp2 ON cp1.uuid = cp2.uuid " +
                    "            AND cp1.vendor = cp2.vendor " +
                    "            AND cp1.price_type = cp2.price_type " +
                    "            AND cp1.currency = cp2.currency " +
                    "    JOIN " +
                    "        cardlegalities cl ON cp1.uuid = cl.uuid " +
                    "    JOIN " +
                    "        cardpurchaseurls cpu ON c.uuid = cpu.uuid " +
                    "    WHERE " +
                    "        cp1.price_date = '2024-06-11' " +
                    "        AND cp2.price_date = '2024-06-17' " +
                    "        AND cl.standard = 'Legal' " +
                    "        AND cp1.vendor = 'tcgplayer' " +
                    "        AND cp1.price_type = 'retail_normal' " +
                    "        AND c.setCode IN ('MID', 'VOW', 'NEO', 'SNC', 'DMU', 'BRO', 'ONE', 'MOM', 'MAT', 'WOE', 'WOT', 'LCI', 'MKM', 'OTJ', 'BIG', 'OTP') " +
                    "        AND cp1.currency = 'USD' " +
                    "    ORDER BY " +
                    "        price_difference DESC " +
                    "    LIMIT 5 " + // Top 5 movers
                    ") " +
                    "UNION ALL " +
                    "(" +
                    "    SELECT " +
                    "        DISTINCT c.name AS name, " +
                    "        c.id AS id, " +
                    "        c.rarity AS rarity, " +
                    "        c.colors AS colors, " +
                    "        c.type AS type, " +
                    "        c.setCode AS setCode, " +
                    "        c.manaValue AS manaValue, " +
                    "        cp1.vendor AS vendor, " +
                    "        cp1.price_type AS price_type, " +
                    "        cp1.price_date AS price_date1, " +
                    "        cp1.price AS price1, " +
                    "        cp2.price_date AS price_date2, " +
                    "        cp2.price AS price2, " +
                    "        cp1.currency AS currency, " +
                    "        cpu.tcgplayer AS purchase_url, " +
                    "        cp2.price - cp1.price AS price_difference " +
                    "    FROM " +
                    "        cards c " +
                    "    JOIN " +
                    "        cardprices cp1 ON c.uuid = cp1.uuid " +
                    "    JOIN " +
                    "        cardprices cp2 ON cp1.uuid = cp2.uuid " +
                    "            AND cp1.vendor = cp2.vendor " +
                    "            AND cp1.price_type = cp2.price_type " +
                    "            AND cp1.currency = cp1.currency " +
                    "    JOIN " +
                    "        cardlegalities cl ON cp1.uuid = cl.uuid " +
                    "    JOIN " +
                    "        cardpurchaseurls cpu ON c.uuid = cpu.uuid " +
                    "    WHERE " +
                    "        cp1.price_date = '2024-06-11' " +
                    "        AND cp2.price_date = '2024-06-17' " +
                    "        AND cl.standard = 'Legal' " +
                    "        AND cp1.vendor = 'tcgplayer' " +
                    "        AND cp1.price_type = 'retail_normal' " +
                    "        AND c.setCode IN ('MID', 'VOW', 'NEO', 'SNC', 'DMU', 'BRO', 'ONE', 'MOM', 'MAT', 'WOE', 'WOT', 'LCI', 'MKM', 'OTJ', 'BIG', 'OTP') " +
                    "        AND cp1.currency = 'USD' " +
                    "    ORDER BY " +
                    "        price_difference ASC " +
                    "    LIMIT 5 " + // Bottom 5 movers
                    ");";


    private static final String SELECT_BY_SET = "SELECT " +
            "    DISTINCT c.name AS name, " +
            "    c.id AS id, " +
            "    c.rarity AS rarity, " +
            "    c.colors AS colors, " +
            "    c.type AS type, " +
            "    c.manaValue AS manaValue, " +
            "    c.setCode AS setCode, " +
            "    cp1.vendor AS vendor, " +
            "    cp1.price_type AS price_type, " +
            "    cp1.price_date AS price_date1, " +
            "    cp1.price AS price1, " +
            "    cp2.price_date AS price_date2, " +
            "    cp2.price AS price2, " +
            "    cp1.currency AS currency, " +
            "    cpu.tcgplayer AS purchase_url, " +
            "    cp2.price - cp1.price AS price_difference " +
            "FROM " +
            "    cards c " +
            "JOIN " +
            "    cardprices cp1 ON c.uuid = cp1.uuid " +
            "JOIN " +
            "    cardprices cp2 ON cp1.uuid = cp2.uuid " +
            "    AND cp1.vendor = cp2.vendor " +
            "    AND cp1.price_type = cp2.price_type " +
            "    AND cp1.currency = cp2.currency " +
            "JOIN " +
            "    cardlegalities cl ON cp1.uuid = cl.uuid " +
            "    JOIN " +
            "        cardpurchaseurls cpu ON c.uuid = cpu.uuid " +
            "WHERE " +
            "setCode IN ('MID', 'VOW', 'NEO', 'SNC', 'DMU', 'BRO', 'ONE', 'MOM', 'MAT', 'WOE', 'WOT', 'LCI', 'MKM', 'OTJ', 'BIG', 'OTP') "
            +
            "    AND cp1.price_date = '2024-06-11' " +
            "    AND cp2.price_date = '2024-06-17' " +
            "    AND cl.standard = 'Legal' " +
            "    AND cp1.vendor = 'tcgplayer' " +
            "    AND cp1.price_type = 'retail_normal' " +
            "    AND cp1.currency = 'USD' " +
            "    AND c.setCode = ? " +
            "ORDER BY " +
            "    price_difference DESC";

    private static final String selectByName = "SELECT " +
            "c.name AS name, " +
            "c.id AS id, " +
            "c.rarity AS rarity, " +
            "c.colors AS colors, " +
            "c.type AS type, " +
            "c.manaValue AS manaValue, " +
            "c.setCode AS setCode, " +
            "cp1.vendor AS vendor, " +
            "cp1.price_type AS price_type, " +
            "cp1.price_date AS price_date1, " +
            "cp1.price AS price1, " +
            "cp2.price_date AS price_date2, " +
            "cp2.price AS price2, " +
            "cp1.currency AS currency, " +
            "cpu.tcgplayer AS purchase_url, " +
            "cp2.price - cp1.price AS price_difference " +
            "FROM " +
            "    cards c " +
            "JOIN " +
            "    cardprices cp1 ON c.uuid = cp1.uuid " +
            "JOIN " +
            "    cardprices cp2 ON cp1.uuid = cp2.uuid " +
            "    AND cp1.vendor = cp2.vendor " +
            "    AND cp1.price_type = cp2.price_type " +
            "    AND cp1.currency = cp2.currency " +
            "JOIN " +
            "    cardlegalities cl ON cp1.uuid = cl.uuid " +
            "    JOIN " +
            "        cardpurchaseurls cpu ON c.uuid = cpu.uuid " +
            "WHERE " +
            "setCode IN ('MID', 'VOW', 'NEO', 'SNC', 'DMU', 'BRO', 'ONE', 'MOM', 'MAT', 'WOE', 'WOT', 'LCI', 'MKM', 'OTJ', 'BIG', 'OTP') "
            +
            "    AND cp1.price_date = '2024-06-11' " +
            "    AND cp2.price_date = '2024-06-17' " +
            "    AND cl.standard = 'Legal' " +
            "    AND cp1.vendor = 'tcgplayer' " +
            "    AND cp1.price_type = 'retail_normal' " +
            "    AND cp1.currency = 'USD' " +
            "   AND c.name LIKE ? ";

    private static final String selectById = "SELECT " +
            "c.name AS name, " +
            "c.id AS id, " +
            "c.rarity AS rarity, " +
            "c.colors AS colors, " +
            "c.type AS type, " +
            "c.manaValue AS manaValue, " +
            "c.setCode AS setCode, " +
            "cp1.vendor AS vendor, " +
            "cp1.price_type AS price_type, " +
            "cp1.price_date AS price_date1, " +
            "cp1.price AS price1, " +
            "cp2.price_date AS price_date2, " +
            "cp2.price AS price2, " +
            "cp1.currency AS currency, " +
            "cpu.tcgplayer AS purchase_url, " +
            "cp2.price - cp1.price AS price_difference " +
            "FROM " +
            "    cards c " +
            "JOIN " +
            "cardpurchaseurls cpu ON c.id = cpu.id " +
            "JOIN " +
            "    cardprices cp1 ON c.uuid = cp1.uuid " +
            "JOIN " +
            "    cardprices cp2 ON cp1.uuid = cp2.uuid " +
            "    AND cp1.vendor = cp2.vendor " +
            "    AND cp1.price_type = cp2.price_type " +
            "    AND cp1.currency = cp2.currency " +
            "JOIN " +
            "    cardlegalities cl ON cp1.uuid = cl.uuid " +
            "    JOIN " +
            "        cardpurchaseurls cpu ON c.uuid = cpu.uuid " +
            "WHERE " +
            "    c.id = ?";

    @Override
    public List<Card> getCards() {
        List<Card> myCards = new ArrayList<>();

        try (Connection conn = MariaDbUtil.getConnection();
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(SELECT_ALL_CARDS)) {
            myCards = makeCard(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myCards;
    }

    @Override
    public List<Card> getTopMovers() {
        List<Card> myCards = new ArrayList<>();

        try (Connection conn = MariaDbUtil.getConnection();
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(SELECT_TOP_MOVERS)) {
            myCards = makeCard(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myCards;
    }

    private List<Card> makeCard(ResultSet result) throws SQLException {
        List<Card> myCards = new ArrayList<>();

        while (result.next()) {
            Card card = new Card();

            card.setCardId(result.getInt("id"));
            card.setName(result.getString("name"));
            card.setColor(result.getString("colors"));
            String rarityString = result.getString("rarity");
            card.setRarity(Rarity.convertStringToRarity(rarityString));

            String typeString = result.getString("type");
            card.setType(Type.convertStringToType(typeString));

            String codeString = result.getString("setCode");
            card.setCode(Code.convertStringToSet(codeString));

            card.setCMC(result.getInt("manaValue"));
            card.setPrice1(result.getDouble("price1"));
            card.setPrice2(result.getDouble("price2"));
            card.setPriceDiff(result.getDouble("price_difference"));
            card.setPurchaseUrl(result.getString("purchase_url"));
            myCards.add(card);
        }

        return myCards;
    }

    @Override
    public List<Card> getCardsBySetCode(Code code) {
        List<Card> myCards = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement statement = null;
        Connection conn = null;

        try {
            conn = MariaDbUtil.getConnection();
            statement = conn.prepareStatement(SELECT_BY_SET);
            statement.setString(1, code.toString());

            result = statement.executeQuery();
            myCards = makeCard(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return myCards;
    }

    @Override
    public List<Card> getCardsByRarity(Rarity rarity) {
        return List.of();
    }

    @Override
    public List<Card> getCardsById(Integer cardIdValue) {
        List<Card> myCards = new ArrayList<>();

        try (Connection conn = MariaDbUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(selectById)) {

            pstmt.setInt(1, cardIdValue);

            try (ResultSet result = pstmt.executeQuery()) {
                myCards = makeCard(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myCards;
    }

    @Override
    public List<Card> getCardsByName(String nameValue) {
        List<Card> myCards = new ArrayList<>();

        try (Connection conn = MariaDbUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(selectByName)) {

            String nameWrap = "%" + nameValue + "%";
            pstmt.setString(1, nameWrap);

            try (ResultSet result = pstmt.executeQuery()) {
                myCards = makeCard(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myCards;
    }

    @Override
    public List<Card> getCardsByCMC(Integer manaValue) {
        return List.of();
    }

    @Override
    public List<Card> getCardsByColor(String colorValue) {
        return List.of();
    }

    @Override
    public List<Card> getCardsByType(Type type) {
        return List.of();
    }

}
