package com.mmattei.BlackJack.api;

import com.mmattei.BlackJack.api.output.GameStatusDTO;
import com.mmattei.BlackJack.application.GameService;
import com.mmattei.BlackJack.domain.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public GameStatusDTO createNewGame(@RequestParam Integer userId) {
        var game = gameService.createGame(userId);
        return mapToDTO(game);
    }

    @PostMapping("/{gameId}/nextRound")
    public GameStatusDTO nextRound(@PathVariable Integer gameId, @RequestParam Integer userId) {
        var game = gameService.nextRound(gameId, userId);
        return mapToDTO(game);
    }

    @GetMapping("/{gameId}")
    public GameStatusDTO getGameStatus(@PathVariable Integer gameId, @RequestParam Integer userId) {
        var game = gameService.getGame(gameId, userId);
        return mapToDTO(game);
    }

    private GameStatusDTO mapToDTO(Game game) {
        var playerHand = game.getPlayer();
        var tableHand = game.getTable();
        var dto = new GameStatusDTO();

        dto.setGameId(game.getId());

        dto.setPlayerHand(playerHand.getHandString());
        dto.setPlayerPoints(playerHand.getPoints());
        dto.setTableHand(tableHand.getHandString());
        dto.setTablePoints(tableHand.getPoints());

        dto.setGameOver(game.gameOver());
        dto.setPlayerWon(game.isPlayerWon());
        dto.setTableWon(game.isTableWon());
        dto.setGameTied(game.isTie());

        return dto;
    }

}
