/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;

public class WarPlayer extends Player {
    private final ArrayList<StandardCard> cardsWon = new ArrayList();
    private StandardCard drawnCard;

    public WarPlayer(String name) {
        super(name);
    }

    public ArrayList<StandardCard> getPlayingHand() {
        return this.cardsWon;
    }

    public String toString() {
        StringBuilder cardListOutput = new StringBuilder();
        int i = 0;

        for(Iterator var3 = this.cardsWon.iterator(); var3.hasNext(); ++i) {
            StandardCard aCard = (StandardCard)var3.next();
            cardListOutput.append("\n").append(i).append("-").append(aCard.toString());
        }

        return cardListOutput.toString();
    }

    public void draw(Deck deck) {
        this.drawnCard = (StandardCard)deck.getCards().get(0);
        deck.getCards().remove(0);
    }

    public StandardCard getDrawnCard() {
        return this.drawnCard;
    }

    public ArrayList<StandardCard> getCardsWon() {
        return this.cardsWon;
    }

    public void play() {
    }
}
