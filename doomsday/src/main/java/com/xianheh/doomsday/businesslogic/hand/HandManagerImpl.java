package com.xianheh.doomsday.businesslogic.hand;

import com.xianheh.doomsday.businesslogic.deck.DeckManager;
import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.exception.HandException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Component(value = HandManager.CONTEXT_ID)
public class HandManagerImpl implements HandManager {
    @Resource
    private DeckManager deckManager;

    @Override
    public Card playCard(Deck deck, Hand hand, int handIndex) throws DeckException {
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

    @Override
    public Hand drawHand(Deck deck) throws DeckException {
        // To be implemented
        return null;
    }
}
