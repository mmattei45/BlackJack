package com.mmattei.BlackJack.domain.repository;

import com.mmattei.BlackJack.domain.entity.Game;

public interface GameRepository {

    public int getNextId();
    public void save(Game game);
    public Game getByGameIdAndPlayerId(int gameId, int playerId);

}
