package com.mmattei.BlackJack.api.output;

import lombok.Data;

import java.util.List;

@Data
public class GameStatusDTO {

    private int gameId;

    private String playerHand;
    private int playerPoints;
    private String tableHand;
    private int tablePoints;

    private boolean gameOver;
    private boolean playerWon;
    private boolean tableWon;
    private boolean gameTied;

}
