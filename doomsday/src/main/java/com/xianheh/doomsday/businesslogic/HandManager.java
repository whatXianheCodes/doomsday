package com.xianheh.doomsday.businesslogic;

import com.xianheh.doomsday.exception.HandException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public interface HandManager {

    public Card playCard(Deck deck, Hand hand, int handIndex);

    public Card[] getHand(Hand hand);

    public Card getCard(Hand hand, int handIndex) throws HandException;
}
