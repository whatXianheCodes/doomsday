package com.xianheh.doomsday.model.game;

import com.xianheh.doomsday.exception.GameException;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.player.Player;
import lombok.Data;

import java.util.List;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class Game {
    private GameType gameType;
    private String id;
    private List<Player> players;
    private int maxPlayerAllowed;
    private Deck deck;
    private boolean isOver;

    public Game(String id, GameType gameType, Deck deck, List<Player> players, int maxPlayerAllowed) throws GameException {
        if (maxPlayerAllowed > players.size()) {
            throw new GameException("Exceed maximum allowed players");
        }

        this.gameType = gameType;
        this.deck = deck;
        this.id = id;
        this.players = players;
        this.maxPlayerAllowed = maxPlayerAllowed;
        this.isOver = false;
    }

    public Game(String id, GameType gameType, Deck deck, int maxPlayerAllowed) throws GameException {
        this.deck = deck;
        this.gameType = gameType;
        this.id = id;
        this.maxPlayerAllowed = maxPlayerAllowed;
        this.isOver = false;
    }
}
