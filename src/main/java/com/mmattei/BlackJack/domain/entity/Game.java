package com.mmattei.BlackJack.domain.entity;

public class Game {

    private boolean tie = false;
    private boolean tableWon = false;
    private boolean playerWon = false;

    private Deck deck;
    private Hand table;
    private Hand player;

    public Game(Deck deck, Hand table, Hand player) {
        this.deck = deck;
        this.table = table;
        this.player = player;
    }

    public void nextRound() {
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

    public boolean tie() {
        return tie;
    }

    public boolean playerWon() {
        return playerWon;
    }

    public boolean tableWon() {
        return tableWon;
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
