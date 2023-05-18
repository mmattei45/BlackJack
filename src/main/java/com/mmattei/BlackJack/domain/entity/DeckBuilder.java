package com.mmattei.BlackJack.domain.entity;

import java.util.ArrayList;

public class DeckBuilder {

    private static final Integer ACE_LOW_POINTS = 1;
    private static final Integer ACE_HIGH_POINTS = 10;

    public static Deck getDeckWithLowPointsAce() {
        return getDeck(ACE_LOW_POINTS);
    }

    public static Deck getDeckWithHighPointsAce() {
        return getDeck(ACE_HIGH_POINTS);
    }

    private static Deck getDeck(int acePoints) {
        var cards = new ArrayList<Card>();

        for (int i = 0; i < 4; i++) {
            cards.add(new Card(acePoints, "A"));
            cards.add(new Card(2, "2"));
            cards.add(new Card(3, "3"));
            cards.add(new Card(4, "4"));
            cards.add(new Card(5, "5"));
            cards.add(new Card(6, "6"));
            cards.add(new Card(7, "7"));
            cards.add(new Card(8, "8"));
            cards.add(new Card(9, "9"));
            cards.add(new Card(10, "10"));
            cards.add(new Card(10, "J"));
            cards.add(new Card(10, "Q"));
            cards.add(new Card(10, "K"));
        }

        return new Deck(cards);
    }

}
