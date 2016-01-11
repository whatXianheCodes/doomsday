package com.xianheh.doomsday.model.hand;

import com.google.common.collect.Lists;
import com.xianheh.doomsday.model.card.Card;
import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */

@Data
public class Hand {
    private Card[] cards;
    private int maxHandSize;

    public Hand (int maxHandSize) {
        cards = new Card[maxHandSize];
        this.maxHandSize = maxHandSize;
    }
}
