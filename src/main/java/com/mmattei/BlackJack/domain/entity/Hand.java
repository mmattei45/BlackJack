package com.mmattei.BlackJack.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private static final int MAX_POINTS = 21;

    private List<Card> cards = new ArrayList<>();
    private int points = 0;

    public void addCard(Card card) {
        cards.add(card);
        points += card.getValue();
    }

    public int getPoints() {
        return points;
    }

    public boolean won() {
        return points == MAX_POINTS;
    }

    public boolean lost() {
        return points > MAX_POINTS;
    }

    public List<Card> getCards() {
        return cards;
    }

}
