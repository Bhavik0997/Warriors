package ca.sheridancollege.project;
/**
 * @ author Neil-Bryan Caoile
 */

import java.util.ArrayList;
import java.util.Random;


//**************************************************************
//          This class imitates deck in a card game.
//**************************************************************
public class Deck {
    private ArrayList<StandardCard> cards = new ArrayList();

    public Deck() {
    }

    public ArrayList<StandardCard> getCards() {
        return this.cards;
    }

    //This method shuffle the StandardCard in the deck.
    public void shuffle() {
        ArrayList<StandardCard> tmpDeck = new ArrayList();
        Random random = new Random();
        int originalSize = this.cards.size();

        for(int i = 0; i < originalSize; ++i) {
            int randomCardIndex = random.nextInt(this.cards.size() - 1 + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }

        this.cards = tmpDeck;
    }
    //This method create a 52 unique StandardCards.
    public void createFullDeck() {
        Suit[] var1 = Suit.values();


        for (Suit cardSuit : var1) {
            Value[] var5 = Value.values();
            int var6 = var5.length;

            for (Value cardValue : var5) {
                this.cards.add(new StandardCard(cardSuit, cardValue));
            }
        }

    }

}

