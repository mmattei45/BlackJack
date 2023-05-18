package com.mmattei.BlackJack.infra;

import com.mmattei.BlackJack.domain.entity.Deck;
import com.mmattei.BlackJack.domain.entity.Game;
import com.mmattei.BlackJack.domain.entity.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameRepositoryMemoryTest {

    @Test
    public void shouldSaveAGame() {
        var game = createGame(1, 1);
        var sot = new GameRepositoryMemory();

        var games = getSavedGamesList(sot);
        Assertions.assertEquals(0, games.size());

        sot.save(game);
        Assertions.assertEquals(1, games.size());
    }

    @Test
    public void shouldFindASavedGame() {
        var game = createGame(1, 1);
        var sot = new GameRepositoryMemory();

        sot.save(game);

        Assertions.assertNotNull(sot.getByGameIdAndPlayerId(1, 1));
    }

    @Test
    public void shouldNotSaveAGameWithAnExistingId() {

    }

    private List<Game> getSavedGamesList(GameRepositoryMemory repo) {
        return (List<Game>) ReflectionTestUtils.getField(repo, "games");
    }

    private Game createGame(int id, int playerId) {
        return new Game(new Deck(new ArrayList<>()), new Hand(), new Hand(), id, playerId);
    }

}