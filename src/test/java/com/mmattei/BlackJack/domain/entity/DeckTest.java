package com.mmattei.BlackJack.domain.entity;

import com.mmattei.BlackJack.domain.exception.NoMoreCardsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class DeckTest {

    @Mock private List<Card> cardsMock;
    @InjectMocks private Deck sotMockito;

    @Test
    public void drawCard() {
        var cards = createIncrementalCardList(3);
        var sot = new Deck(cards);

        var card = sot.drawCard();

        assertEquals(2, cards.size());
        assertEquals(2, card.getValue());
    }

    @Test
    // Esse teste exemplifica o uso do mockito.
    public void drawCard_noMoreCards() {
        Mockito.when(cardsMock.isEmpty()).thenReturn(true);
        assertThrows(NoMoreCardsException.class, () -> sotMockito.drawCard());
    }

    public List<Card> createIncrementalCardList(int cardCount) {
        var cards = new ArrayList<Card>();

        for (int i = 0; i < cardCount; i++) {
            cards.add(new Card(i, i + ""));
        }

        return cards;
    }

}
