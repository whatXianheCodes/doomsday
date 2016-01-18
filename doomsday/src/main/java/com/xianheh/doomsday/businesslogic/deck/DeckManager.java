package com.xianheh.doomsday.businesslogic.deck;

import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.deck.Deck;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public interface DeckManager {

    public static final String CONTEXT_ID = "DeckManager";

    public Deck createDeck(int deckSize);

    public Card drawCard(Deck deck) throws DeckException;

    public void shuffleDeck(Deck deck);
}
