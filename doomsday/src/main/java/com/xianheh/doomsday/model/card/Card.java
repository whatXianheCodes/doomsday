package com.xianheh.doomsday.model.card;

import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class Card {
    private Suit suit;
    private Rank rank;
    private int id;

    public Card(Suit suit, Rank rank, int id) {
        this.suit = suit;
        this.rank = rank;
        this.id = id;
    }
}
