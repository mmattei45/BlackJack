package com.mmattei.BlackJack.domain.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Hand {

    private static final int MAX_POINTS = 21;

    private List<Card> cards = new ArrayList<>();
    private int points = 0;

    public void addCard(Card card) {
        cards.add(card);
        points += card.getValue();
    }

    public boolean won() {
        return points == MAX_POINTS;
    }

    public boolean lost() {
        return points > MAX_POINTS;
    }

    public String getHandString() {
        return cards.stream()
                .map(it -> "'" + it.getSymbol() + "'")
                .collect(Collectors.joining(", "));
    }

}
