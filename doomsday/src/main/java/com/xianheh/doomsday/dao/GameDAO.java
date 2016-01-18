package com.xianheh.doomsday.dao;

import com.xianheh.doomsday.exception.GameException;
import com.xianheh.doomsday.model.game.Game;

import java.util.List;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public interface GameDAO {

    public static final String CONTEXT_ID = "GameDAO";

    public List<Game> getAllGames();

    public Game getGame(String gameId) throws GameException;

    public void insertGame(Game game);

    public void updateGame(String gameId, Game game) throws GameException;

    public void deleteGame(String gameId) throws GameException;
}
