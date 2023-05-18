package com.mmattei.BlackJack.domain.entity;

import lombok.Getter;

@Getter
public class Game {

    private int id;
    private int playerId;

    private boolean tie = false;
    private boolean tableWon = false;
    private boolean playerWon = false;

    private Deck deck;
    private Hand table;
    private Hand player;

    public Game(Deck deck, Hand table, Hand player, int id, int playerId) {
        this.deck = deck;
        this.table = table;
        this.player = player;
        this.id = id;
        this.playerId = playerId;
    }

    public void nextRound() {
        if (gameOver()) return;

        dealCards();

        if (bothWon() || bothLost()) {
            tie = true;
            return;
        }

        playerWon = player.won() || table.lost();
        tableWon = table.won() || player.lost();
    }

    public boolean gameOver() {
        return playerWon || tableWon || tie;
    }

    private void dealCards() {
        var tableDraw = deck.drawCard();
        var playerDraw = deck.drawCard();
        table.addCard(tableDraw);
        player.addCard(playerDraw);
    }

    private boolean bothLost() {
        return player.lost() && table.lost();
    }

    private boolean bothWon() {
        return player.won() && table.won();
    }

}
