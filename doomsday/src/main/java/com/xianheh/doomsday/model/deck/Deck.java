package com.xianheh.doomsday.model.deck;

import com.xianheh.doomsday.model.card.Card;
import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */

@Data
public class Deck {
    private Card[] deck;
    private int maxDeckSize;
    private int numCardsLeft;

    public Deck(int maxDeckSize) {
        deck = new Card[maxDeckSize];
        this.maxDeckSize = maxDeckSize;
        numCardsLeft = maxDeckSize;
    }
}
