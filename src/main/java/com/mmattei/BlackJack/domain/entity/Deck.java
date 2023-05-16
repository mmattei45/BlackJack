package com.mmattei.BlackJack.domain.entity;

import com.mmattei.BlackJack.domain.exception.NoMoreCardsException;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class Deck {

    private List<Card> cards;

    public Card drawCard() {
        if (cards.isEmpty())
            throw new NoMoreCardsException();

        return cards.remove(cards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
