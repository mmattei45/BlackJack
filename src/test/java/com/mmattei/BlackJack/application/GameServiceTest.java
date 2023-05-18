package com.mmattei.BlackJack.application;

import com.mmattei.BlackJack.domain.entity.Game;
import com.mmattei.BlackJack.domain.exception.NotFoundException;
import com.mmattei.BlackJack.domain.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceTest {

    private static final int PLAYER_ID = 1;

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;



    @BeforeEach
    public void beforeEach() {
        ReflectionTestUtils.setField(gameRepository, "games", new ArrayList<Game>());
    }



    @Test
    public void shouldCreateAGame() {
        var game = gameService.createGame(PLAYER_ID);

        var fetchedGame = gameRepository.getByGameIdAndPlayerId(game.getId(), PLAYER_ID);
        assertNotNull(fetchedGame);
    }

    @Test
    public void shouldDealCardsEveryRound() {
        var game = gameService.createGame(PLAYER_ID);
        gameService.nextRound(game.getId(), PLAYER_ID);

        var playerHand = game.getPlayer();
        var tableHand = game.getTable();
        assertTrue(playerHand.getPoints() > 0);
        assertTrue(tableHand.getPoints() > 0);
    }

    @Test
    public void shouldValidatePlayerBeforeNextRound() {
        var game = gameService.createGame(PLAYER_ID);
        assertThrows(NotFoundException.class, () -> gameService.nextRound(game.getId(), PLAYER_ID + 1));
    }

    @Test
    public void shouldOnlyFindPlayersGame() {
        var game = gameService.createGame(PLAYER_ID);

        Game fetchedGame = gameService.getGame(game.getId(), PLAYER_ID);
        assertNotNull(fetchedGame);

        assertThrows(NotFoundException.class, () -> gameService.getGame(game.getId(), PLAYER_ID + 1));
    }

}
