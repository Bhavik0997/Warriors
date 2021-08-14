package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck {
    private int size;
    private ArrayList<StandardCard> cards = new ArrayList();

    public Deck() {
    }

    public ArrayList<StandardCard> getCards() {
        return this.cards;
    }

    public void shuffle() {
        ArrayList<StandardCard> tmpDeck = new ArrayList();
        Random random = new Random();
        int originalSize = this.cards.size();

        for(int i = 0; i < originalSize; ++i) {
            int randomCardIndex = random.nextInt(this.cards.size() - 1 + 1);
            tmpDeck.add((StandardCard)this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }

        this.cards = tmpDeck;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void createFullDeck() {
        Suit[] var1 = Suit.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Suit cardSuit = var1[var3];
            Value[] var5 = Value.values();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Value cardValue = var5[var7];
                this.cards.add(new StandardCard(cardSuit, cardValue));
            }
        }

    }

    public String toString() {
        StringBuilder cardListOutput = new StringBuilder();
        int i = 0;

        for(Iterator var3 = this.cards.iterator(); var3.hasNext(); ++i) {
            StandardCard aCard = (StandardCard)var3.next();
            cardListOutput.append("\n").append(i).append("-").append(aCard.toString());
        }

        return cardListOutput.toString();
    }
}

