/**
 * @ author Neil-Bryan Caoile
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;

public class WarPlayer extends Player {
    private final ArrayList<StandardCard> cardsWon = new ArrayList<>();
    private StandardCard drawnCard;

    public WarPlayer(String name) {
        super(name);
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
    
    //Just for junit testing.
    public void setDrawnCard(StandardCard drawnCard){
        this.drawnCard = drawnCard;
    }

    //This method allows a player to draw from the deck
    public void draw(Deck deck) {
        this.drawnCard = deck.getCards().get(0);
        deck.getCards().remove(0);
    }

    //A method where gets the currently drawn cards of the user.
    public StandardCard getDrawnCard() {
        return this.drawnCard;
    }

    //A method that return an arrayList of StandardCard.
    //These cards were gained by winning each round.
    public ArrayList<StandardCard> getCardsWon() {
        return this.cardsWon;
    }

}
