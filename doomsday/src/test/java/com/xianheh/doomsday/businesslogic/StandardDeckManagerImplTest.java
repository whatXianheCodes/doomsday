package com.xianheh.doomsday.businesslogic;

import com.xianheh.doomsday.businesslogic.deck.DeckManager;
import com.xianheh.doomsday.exception.DeckException;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.card.Rank;
import com.xianheh.doomsday.model.card.Suit;
import com.xianheh.doomsday.model.deck.Deck;
import junit.framework.Assert;
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
public class StandardDeckManagerImplTest {
    @Resource
    private DeckManager deckManager;

    @Test
    public void testCreateDeck() {
        Deck deck = deckManager.createDeck(52);
        System.out.println(deck);
    }

    @Test
    public void testDrawCard() throws DeckException {
        Deck deck = deckManager.createDeck(52);
        int numCardsLeft = deck.getNumCardsLeft();
        int cardIndex = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = deckManager.drawCard(deck);
                Assert.assertEquals(rank, card.getRank());
                Assert.assertEquals(suit, card.getSuit());
                Assert.assertEquals(cardIndex++, card.getId());
                Assert.assertEquals(--numCardsLeft, deck.getNumCardsLeft());
            }
        }
        try {
            deckManager.drawCard(deck);
        } catch (DeckException e) {
            Assert.assertEquals("No cards in deck", e.getMessage());
        }
    }

    @Test
    public void testDeckShuffle() {
        Deck deck = deckManager.createDeck(52);
        deckManager.shuffleDeck(deck);
        System.out.println(deck);
    }
}
