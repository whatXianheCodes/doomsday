package com.xianheh.doomsday.businesslogic;

import com.xianheh.doomsday.businesslogic.deck.DeckManager;
import com.xianheh.doomsday.businesslogic.hand.TexasHoldEmHandManagerImpl;
import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.exception.HandException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.card.Rank;
import com.xianheh.doomsday.model.card.Suit;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath:businesslogic.xml")
public class HandManagerTest {
    @Resource
    private DeckManager deckManager;
    @Resource
    private TexasHoldEmHandManagerImpl texasHoldEmHandManager;
    private Deck deck;
    private Card[] knownHand;

    @Before
    public void init() {
        deck = deckManager.createDeck(52);
        knownHand = new Card[5];
        knownHand[0] = new Card(Suit.HEARTS, Rank.ACE, 0);
        knownHand[1] = new Card(Suit.HEARTS, Rank.TWO, 1);
        knownHand[2] = new Card(Suit.HEARTS, Rank.THREE, 2);
        knownHand[3] = new Card(Suit.HEARTS, Rank.FOUR, 3);
        knownHand[4] = new Card(Suit.HEARTS, Rank.FIVE, 4);
    }

    @Test
    public void testHand() throws DeckException {
        Hand hand = texasHoldEmHandManager.drawHand(deck);
        Card[] drawnCards = texasHoldEmHandManager.getHand(hand);
        for(int handIndex = 0; handIndex < TexasHoldEmHandManagerImpl.HAND_SIZE; handIndex++) {
            Assert.assertEquals(drawnCards[handIndex], knownHand[handIndex]);
        }
    }

    @Test
    public void testGetHand() throws DeckException, HandException {
        Hand hand = texasHoldEmHandManager.drawHand(deck);
        for(int handIndex = 0; handIndex < TexasHoldEmHandManagerImpl.HAND_SIZE; handIndex++) {
            Assert.assertEquals(texasHoldEmHandManager.getCard(hand, handIndex), knownHand[handIndex]);
        }
    }

    @Test
    public void testPlayCard() throws DeckException, HandException {
        int handIndex = 3;
        Hand hand = texasHoldEmHandManager.drawHand(deck);
        Card cardPlayed = texasHoldEmHandManager.playCard(deck, hand, handIndex);
        Assert.assertEquals(knownHand[handIndex], cardPlayed);
        Assert.assertEquals(new Card(Suit.HEARTS, Rank.SIX, 5), texasHoldEmHandManager.getCard(hand, handIndex));
    }
}
