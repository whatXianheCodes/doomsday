package com.xianheh.doomsday.businesslogic.game;

import com.xianheh.doomsday.businesslogic.deck.DeckManager;
import com.xianheh.doomsday.businesslogic.hand.TexasHoldEmHandManagerImpl;
import com.xianheh.doomsday.dao.GameDAO;
import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.exception.GameException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.game.CardGameTable;
import com.xianheh.doomsday.model.game.Game;
import com.xianheh.doomsday.model.game.GameType;
import com.xianheh.doomsday.model.player.Player;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Component(value = "TexasHoldEm")
public class TexasHoldEm {

    public static final int MAX_PLAYER_ALLOWED = 9;
    public static final int DECK_SIZE = 52;
    public static final int MAX_ROUND = 4;

    @Resource
    private GameDAO gameDAO;

    @Resource
    private DeckManager deckManager;

    @Resource
    private TexasHoldEmHandManagerImpl texasHoldEmHandManager;

    private CardGameTable table;

//    public void joinGame(String gameId, Player player) throws GameException {
//        Game game = gameDAO.getGame(gameId);
//        List<Player> players = game.getPlayers();
//        players.add(player);
//        game.setPlayers(players);
//        gameDAO.updateGame(gameId, game);
//    }

    public void initializeGame(List<Player> players) throws GameException, DeckException {
        UUID uuid = UUID.randomUUID();
        Game game = new Game(uuid.toString(), GameType.TEXAS_HOLD_EM, deckManager.createDeck(DECK_SIZE), players,
                MAX_PLAYER_ALLOWED);
        dealCards(game);
        gameDAO.insertGame(game);
    }

    // this isn't server :/
    public void startGame(Game game) throws DeckException {
        int currentRound = 0;
        while(!game.isOver()) {
            Card[] cardsOnTable = table.getCards();
            for (Player player : game.getPlayers()) {
                //analyze what the player currently has
                //player bet
                //player decides move
            }
            currentRound++;
            if (currentRound == 1) {
                for(int cardIndex = 0; cardIndex < 3; cardIndex++) {
                    cardsOnTable[cardIndex] = deckManager.drawCard(game.getDeck());
                }
            }
            if (currentRound == 2 || currentRound == 4) {
                cardsOnTable[currentRound + 1] = deckManager.drawCard(game.getDeck());
            }

            if (currentRound == MAX_ROUND) {
                game.setOver(true);
            }
        }
    }

    private void dealCards(Game game) throws DeckException {
        List<Player> players = game.getPlayers();
        for(Player player : players) {
            player.setHand(texasHoldEmHandManager.drawHand(game.getDeck()));
        }
        game.setPlayers(players);
    }
}
