package com.xianheh.doomsday.model.game;

import com.xianheh.doomsday.model.card.Card;
import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class CardGameTable {
    Card[] cards;
    int numCardShown;

    public CardGameTable(int maxCardAllowed) {
        cards = new Card[maxCardAllowed];
        numCardShown = 0;
    }
}
