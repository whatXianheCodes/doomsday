package com.xianheh.doomsday.dao;

import com.google.common.collect.Lists;
import com.xianheh.doomsday.exception.GameException;
import com.xianheh.doomsday.model.game.Game;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Component(value = GameDAO.CONTEXT_ID)
public class GameDAOImpl implements GameDAO {

    private List<Game> games;

    @PostConstruct
    public void initIt() throws Exception {
        games = Lists.newArrayList();
    }

    @Override
    public List<Game> getAllGames() {
        return games;
    }

    @Override
    public Game getGame(String gameId) throws GameException {
        int gameIndex = findGameIndex(gameId);
        return games.get(gameIndex);
    }

    @Override
    public void insertGame(Game game) {
        games.add(game);
    }

    @Override
    public void updateGame(String gameId, Game game) throws GameException {
        int gameIndex = findGameIndex(gameId);
        games.set(gameIndex, game);
    }

    @Override
    public void deleteGame(String gameId) throws GameException {
        int gameIndex = findGameIndex(gameId);
        games.remove(gameIndex);
    }

    private int findGameIndex(String gameId) throws GameException {
        for(int gameIndex = 0; gameIndex < games.size(); gameIndex++) {
            Game game = games.get(gameIndex);
            if(gameId.equals(game.getId())){
                return gameIndex;
            }
        }
        throw new GameException("Invalid game id");
    }
}
