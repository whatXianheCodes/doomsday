package com.xianheh.doomsday.businesslogic.hand;

import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.exception.HandException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public interface HandManager {

    public static final String CONTEXT_ID = "HandManager";

    public Card playCard(Deck deck, Hand hand, int handIndex) throws DeckException;

    public Card[] getHand(Hand hand);

    public Card getCard(Hand hand, int handIndex) throws HandException;

    public Hand drawHand(Deck deck) throws DeckException;
}
