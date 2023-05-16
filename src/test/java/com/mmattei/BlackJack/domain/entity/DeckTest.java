package com.mmattei.BlackJack.domain.entity;

import com.mmattei.BlackJack.domain.exception.NoMoreCardsException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    public void drawCard() {
        var cards = createIncrementalCardList(3);
        var sot = new Deck(cards);

        var card = sot.drawCard();

        assertEquals(2, cards.size());
        assertEquals(2, card.getValue());
    }

    @Test
    public void drawCard_noMoreCards() {
        var cards = createIncrementalCardList(1);
        var sot = new Deck(cards);

        assertDoesNotThrow(() -> sot.drawCard());
        assertThrows(NoMoreCardsException.class, () -> sot.drawCard());
    }

    public List<Card> createIncrementalCardList(int cardCount) {
        var cards = new ArrayList<Card>();

        for (int i = 0; i < cardCount; i++) {
            cards.add(new Card(i, i + ""));
        }

        return cards;
    }

}
