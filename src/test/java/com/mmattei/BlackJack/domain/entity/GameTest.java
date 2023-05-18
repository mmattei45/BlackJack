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

        var sot = createGame(deck, table, player);
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

        var sot = createGame(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.isTie());
        assertTrue(sot.isTableWon());
        assertFalse(sot.isPlayerWon());
    }

    @Test
    public void tableShouldLose_when_moreThan21Points() {
        var player = createHand(10);
        var table = createHand(19);
        var deck = createTwoCardsDeck(3);

        var sot = createGame(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.isTie());
        assertTrue(sot.isPlayerWon());
        assertFalse(sot.isTableWon());
    }

    @Test
    public void playerShouldWin_when_itHitsExactly21Points() {
        var player = createHand(18);
        var table = createHand(10);
        var deck = createTwoCardsDeck(3);

        var sot = createGame(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.isTie());
        assertTrue(sot.isPlayerWon());
        assertFalse(sot.isTableWon());
    }

    @Test
    public void playerShouldLose_when_moreThan21Points() {
        var player = createHand(19);
        var table = createHand(10);
        var deck = createTwoCardsDeck(3);

        var sot = createGame(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertFalse(sot.isTie());
        assertTrue(sot.isTableWon());
        assertFalse(sot.isPlayerWon());
    }

    @Test
    public void tie_when_bothWin() {
        var player = createHand(18);
        var table = createHand(18);
        var deck = createTwoCardsDeck(3);

        var sot = createGame(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertTrue(sot.isTie());
        assertFalse(sot.isTableWon());
        assertFalse(sot.isPlayerWon());
    }

    @Test
    public void tie_when_bothLose() {
        var player = createHand(19);
        var table = createHand(19);
        var deck = createTwoCardsDeck(3);

        var sot = createGame(deck, table, player);
        sot.nextRound();

        assertTrue(sot.gameOver());
        assertTrue(sot.isTie());
        assertFalse(sot.isTableWon());
        assertFalse(sot.isPlayerWon());
    }



    private Game createGame(Deck deck, Hand table, Hand player) {
        return createGame(deck, table, player);
    }

    private Deck createTwoCardsDeck(int cardPoints) {
        var card1 = createCard(cardPoints);
        var card2 = createCard(cardPoints);
        var cards = new ArrayList<>(Arrays.asList(card1, card2));

        return new Deck(cards);
    }

    private Hand createHand(int points) {
        var hand = new Hand();
        hand.addCard(createCard(points));
        return hand;
    }

    private Card createCard(int points) {
        return new Card(points, "X");
    }

}
