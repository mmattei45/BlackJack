package com.mmattei.BlackJack.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void drawCard() {
        var player = createHand(2);
        var table = createHand(1);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertEquals(5, player.getPoints());
        assertEquals(4, table.getPoints());
        assertTrue(deck.isEmpty());
    }

    @Test
    public void tableShouldWin_when_itHitsExactly21Points() {
        var player = createHand(10);
        var table = createHand(18);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.tie());
        assertTrue(sot.tableWon());
        assertFalse(sot.playerWon());
    }

    @Test
    public void tableShouldLose_when_moreThan21Points() {
        var player = createHand(10);
        var table = createHand(19);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.tie());
        assertTrue(sot.playerWon());
        assertFalse(sot.tableWon());
    }

    @Test
    public void playerShouldWin_when_itHitsExactly21Points() {
        var player = createHand(18);
        var table = createHand(10);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.tie());
        assertTrue(sot.playerWon());
        assertFalse(sot.tableWon());
    }

    @Test
    public void playerShouldLose_when_moreThan21Points() {
        var player = createHand(19);
        var table = createHand(10);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.tie());
        assertTrue(sot.tableWon());
        assertFalse(sot.playerWon());
    }

    @Test
    public void tie_when_bothWin() {
        var player = createHand(18);
        var table = createHand(18);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertTrue(sot.tie());
        assertFalse(sot.tableWon());
        assertFalse(sot.playerWon());
    }

    @Test
    public void tie_when_bothLose() {
        var player = createHand(19);
        var table = createHand(19);
        var deck = createTwoCardsDeck(3);

        var sot = new Game(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertTrue(sot.tie());
        assertFalse(sot.tableWon());
        assertFalse(sot.playerWon());
    }



    public Deck createTwoCardsDeck(int cardPoints) {
        var card1 = createCard(cardPoints);
        var card2 = createCard(cardPoints);
        var cards = new ArrayList<>(Arrays.asList(card1, card2));

        return new Deck(cards);
    }

    public Hand createHand(int points) {
        var hand = new Hand();
        hand.addCard(createCard(points));
        return hand;
    }

    public Card createCard(int points) {
        return new Card(points, "X");
    }

}
