package com.mmattei.BlackJack.application;

import com.mmattei.BlackJack.domain.entity.DeckBuilder;
import com.mmattei.BlackJack.domain.entity.Game;
import com.mmattei.BlackJack.domain.entity.Hand;
import com.mmattei.BlackJack.domain.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game createGame(int playerId) {
        var id = gameRepository.getNextId();
        var deck = DeckBuilder.getDeckWithHighPointsAce();
        var table = new Hand();
        var player = new Hand();

        var game = new Game(deck, table, player, id, playerId);
        deck.shuffle();

        gameRepository.save(game);
        return game;
    }

    public Game nextRound(int gameId, int playerId) {
        var game = gameRepository.getByGameIdAndPlayerId(gameId, playerId);
        game.nextRound();
        return game;
    }

    public Game getGame(int gameId, int playerId) {
        return gameRepository.getByGameIdAndPlayerId(gameId, playerId);
    }

}
