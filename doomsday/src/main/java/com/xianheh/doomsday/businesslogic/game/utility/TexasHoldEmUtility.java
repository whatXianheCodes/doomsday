package com.xianheh.doomsday.businesslogic.game.utility;

import com.xianheh.doomsday.businesslogic.hand.TexasHoldEmHandManagerImpl;
import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.card.Rank;
import com.xianheh.doomsday.model.card.Suit;
import com.xianheh.doomsday.model.game.HandRank;

import java.util.Collections;
import java.util.List;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public class TexasHoldEmUtility {

    public HandRank determinePokerHand(List<Card> cards) {
        HandRank handRank = new HandRank();
        Collections.sort(cards);




    }

    public boolean checkStraight(List<Card> cards, HandRank handRank) {
        boolean hasAce = cards.get(0).getRank().equals(Rank.ACE);
        int numOfConsecutive = 1;
        for (int cardIndex = 1; cardIndex < TexasHoldEmHandManagerImpl.HAND_SIZE; cardIndex++) {
            int currentCardRank = cards.get(cardIndex).getRank().getValue();
            int previousCardRank = cards.get(cardIndex - 1).getRank().getValue();

            if (currentCardRank - previousCardRank == 1) {
                numOfConsecutive++;
            } else {
                if (hasStraight(numOfConsecutive, previousCardRank, hasAce, handRank)) {
                    return true;
                } else {
                    numOfConsecutive = 1;
                }
            }

            if (cardIndex == TexasHoldEmHandManagerImpl.HAND_SIZE - 1) {
                return hasStraight(numOfConsecutive, previousCardRank, hasAce, handRank);
            }
        }
        return false;
    }

    private boolean checkFlush(List<Card> cards, HandRank handRank) {
        for (Card card : cards) {
            countSuits(card, handRank);
        }
        if (handRank.getNumOfClubs() == 5) {
            handRank.setHighestFlush(returnHighestSuit(Suit.CLUBS, cards));
            return true;
        } else if (handRank.getNumOfHearts() == 5) {
            handRank.setHighestFlush(returnHighestSuit(Suit.HEARTS, cards));
            return true;
        } else if (handRank.getNumOfDiamonds() == 5) {
            handRank.setHighestFlush(returnHighestSuit(Suit.DIAMONDS, cards));
            return true;
        } else if (handRank.getNumOfSpades() == 5) {
            handRank.setHighestFlush(returnHighestSuit(Suit.SPADES, cards));
            return true;
        }
        return false;
    }

    private boolean hasStraight(int numOfConsecutive, int cardRank, boolean hasAce, HandRank handRank) {
        if (numOfConsecutive >= 4 && hasAce && cardRank == 13) {
            handRank.setHighestStraight(14);
            return true;
        } else if (numOfConsecutive >= 5) {
            handRank.setHighestStraight(cardRank);
            return true;
        } else {
            return false;
        }
    }

    private void countSuits(Card card, HandRank handRank) {
        if (card.getSuit().equals(Suit.CLUBS)) {
            handRank.incrementNumOfClubs();
        } else if (card.getSuit().equals(Suit.DIAMONDS)) {
            handRank.incrementNumOfDiamonds();
        } else if (card.getSuit().equals(Suit.HEARTS)) {
            handRank.incrementNumOfHearts();
        } else if (card.getSuit().equals(Suit.SPADES)) {
            handRank.incrementNumOfSpades();
        }
    }

    private int returnHighestSuit(Suit suit, List<Card> cards) {
        for (int cardIndex = TexasHoldEmHandManagerImpl.HAND_SIZE -1; cardIndex >= 0; cardIndex--){
            Card card = cards.get(cardIndex);
            if(card.getSuit().equals(suit)) {
                return card.getRank().getValue();
            }
        }
    }

}
