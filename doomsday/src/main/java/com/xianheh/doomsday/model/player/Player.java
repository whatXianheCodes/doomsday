package com.xianheh.doomsday.model.player;

import com.xianheh.doomsday.model.hand.Hand;
import lombok.Data;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class Player {
    private Hand hand;
    private String id;

    public Player(Hand hand, String id) {
        this.hand = hand;
        this.id = id;
    }
}
