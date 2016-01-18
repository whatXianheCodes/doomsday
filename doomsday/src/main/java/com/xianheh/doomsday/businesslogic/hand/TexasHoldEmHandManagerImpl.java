package com.xianheh.doomsday.businesslogic.hand;

import com.xianheh.doomsday.businesslogic.deck.StandardDeckManagerImpl;
import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Component(value = "TexasHoldEmHandManagerImpl")
public class TexasHoldEmHandManagerImpl extends HandManagerImpl {

    @Resource
    private StandardDeckManagerImpl standardDeckManager;

    public static final int HAND_SIZE = 5;
    @Override
    public Hand drawHand(Deck deck) throws DeckException {
        Hand hand = new Hand(HAND_SIZE);
        Card[] cards = new Card[HAND_SIZE];
        for(int handIndex = 0; handIndex < HAND_SIZE; handIndex++) {
            cards[handIndex] = standardDeckManager.drawCard(deck);
        }
        hand.setCards(cards);
        return hand;
    }
}
