package com.mmattei.BlackJack.infra;

import com.mmattei.BlackJack.domain.entity.Game;
import com.mmattei.BlackJack.domain.repository.GameRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameRepositoryMemory implements GameRepository {

    private List<Game> games = new ArrayList<>();

    @Override
    public int getNextId() {
        return games.size();
    }

    @Override
    public void save(Game game) {
        if (getByGameId(game.getId()) != null)
            throw new RuntimeException();

        games.add(game);
    }

    @Override
    public Game getByGameIdAndPlayerId(int gameId, int playerId) {
        return games.stream()
                .filter(it -> it.getId() == gameId && it.getPlayerId() == playerId)
                .findFirst()
                .orElse(null);
    }

    private Game getByGameId(int id) {
        return games.stream()
                .filter(it -> it.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
