package com.xianheh.doomsday.businesslogic;

import com.xianheh.doomsday.businesslogic.deck.DeckManager;
import com.xianheh.doomsday.exception.HandException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;
import com.xianheh.doomsday.model.player.Player;

import javax.annotation.Resource;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public class HandManagerImpl implements HandManager {
    @Resource
    private DeckManager deckManager;

    @Override
    public Card playCard(Deck deck, Hand hand, int handIndex) {
        Card[] cards = hand.getCards();
        Card cardPlayed = cards[handIndex];
        Card cardDrawn = deckManager.drawCard(deck);
        cards[handIndex] = cardDrawn;
        hand.setCards(cards);
        return cardPlayed;
    }

    @Override
    public Card[] getHand(Hand hand) {
        return hand.getCards();
    }

    @Override
    public Card getCard(Hand hand, int handIndex) throws HandException {
        Card[] cards = hand.getCards();
        if (handIndex > cards.length) {
            throw new HandException("Invalid handIndex");
        }
        return hand.getCards()[handIndex];
    }
}
