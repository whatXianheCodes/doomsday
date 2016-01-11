package com.xianheh.doomsday.businesslogic;

import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.card.Rank;
import com.xianheh.doomsday.model.card.Suit;
import com.xianheh.doomsday.model.deck.Deck;
import com.xianheh.doomsday.model.hand.Hand;
import com.xianheh.doomsday.model.player.Player;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public class HandManagerTest {
    private static Player player;
    private static Deck deck;

    @BeforeClass
    public static void init() {
        Hand hand = new Hand(5);
        hand.setCards(new Card[]{
                new Card(Suit.DIAMONDS, Rank.ACE, 1),
                new Card(Suit.DIAMONDS, Rank.ACE, 1),
                new Card(Suit.DIAMONDS, Rank.ACE, 1),
                new Card(Suit.DIAMONDS, Rank.ACE, 1),
                new Card(Suit.DIAMONDS, Rank.ACE, 1),
        });
        deck = new Deck(52);
        player = new Player(hand, "000001");
    }

    @Test
    public void testPlayCard() {
        System.out.println(player.getHand());
        test(player.getHand());
        System.out.println(player.getHand());
    }

    private void test(Hand hand){
        Card[] cards = hand.getCards();
        Card card = new Card(Suit.CLUBS, Rank.ACE, 1);
        cards[4] = card;
        hand.setCards(cards);
    }
}
