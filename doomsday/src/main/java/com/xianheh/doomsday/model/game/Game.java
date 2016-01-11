package com.xianheh.doomsday.model.game;

import com.xianheh.doomsday.exception.GameException;
import com.xianheh.doomsday.model.player.Player;
import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class Game {
    private GameType gameType;
    private int id;
    private Player[] players;
    private int maxPlayerAllowed;

    public Game(GameType gameType, int id, Player[] players, int maxPlayerAllowed) throws GameException {
        if (maxPlayerAllowed > players.length) {
            throw new GameException("Exeed maximum allowed players");
        }

        this.gameType = gameType;
        this.id = id;
        this.players = players;
        this.maxPlayerAllowed = maxPlayerAllowed;
    }

    public Game(GameType gameType, int id, int maxPlayerAllowed) throws GameException {
        this.gameType = gameType;
        this.id = id;
        this.maxPlayerAllowed = maxPlayerAllowed;
    }
}
