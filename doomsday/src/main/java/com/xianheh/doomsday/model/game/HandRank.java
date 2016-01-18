package com.xianheh.doomsday.model.game;

import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class HandRank {

    private PokerHand pokerHand;
    private int highestSingle;
    private int highestDouble;
    private int highestTriple;
    private int highestFourOfKind;
    private int highestStraight;
    private int highestFlush;
    private int numOfHearts = 0;
    private int numOfSpades = 0;
    private int numOfClubs = 0;
    private int numOfDiamonds = 0;

    public enum PokerHand {
        SINGLE(1),
        DOUBLE(2),
        TRIPLE(3),
        STRAIGHT(4),
        FLUSH(5),
        FULL_HOUSE(6),
        FOUR_OF_A_KIND(7),
        STRAIGHT_FLUSH(8),
        ROYAL_FLUSH(9);

        private int value;

        PokerHand(int value) {
            this.value = value;
        }
    }

    public void incrementNumOfHearts() {
        numOfHearts++;
    }

    public void incrementNumOfDiamonds() {
        numOfDiamonds++;
    }

    public void incrementNumOfSpades() {
        numOfSpades++;
    }

    public void incrementNumOfClubs() {
        numOfClubs++;
    }
}
