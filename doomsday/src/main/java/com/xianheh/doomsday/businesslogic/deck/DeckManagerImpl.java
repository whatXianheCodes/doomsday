package com.xianheh.doomsday.businesslogic.deck;

import com.xianheh.doomsday.model.card.Card;
import com.xianheh.doomsday.model.card.Rank;
import com.xianheh.doomsday.model.card.Suit;
import com.xianheh.doomsday.model.deck.Deck;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */

@Component(value = DeckManager.CONTEXT_ID)
public class DeckManagerImpl implements DeckManager {
    @Override
    public Deck createDeck(int deckSize) {
        Deck deck = new Deck(deckSize);
        Card[] cards = deck.getDeck();
        int cardsIndex = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[cardsIndex++] = new Card(suit, rank, cardsIndex);
            }
        }
        deck.setDeck(cards);
        return deck;
    }

    @Override
    public Card drawCard(Deck deck) {
        Card[] cards = deck.getDeck();
        int numCardsLeft = deck.getNumCardsLeft();
        Card cardDrawn = cards[deck.getMaxDeckSize() - numCardsLeft--];
        deck.setNumCardsLeft(numCardsLeft);
        return cardDrawn;
    }

    @Override
    public void suffleDeck(Deck deck) {
        insideOutShuffleAlgorithm(deck);

    }

    private void insideOutShuffleAlgorithm(Deck deck){
        Random rand = new Random();
        Card[] cards = deck.getDeck();
        for (int i = 1; i <= deck.getMaxDeckSize(); i++) {
            int j = rand.nextInt(i);
            Card temp = cards[i];
            if (i != j) {
                cards[i] = cards[j];
            }
            cards[j] = temp;
        }
        deck.setDeck(cards);
    }
}
