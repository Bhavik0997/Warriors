/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 * @author Darren Scarfo Aug 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<StandardCard> cards;
    private int size;//the size of the grouping
    
    // creates and shuffles deck
    public GroupOfCards(int size) {
        cards = new ArrayList<>();
        for (Suit s : Suit.values ())
            for (Value v : Value.values ())
                cards.add(new StandardCard (v, s));
        Collections.shuffle(cards);
        this.size = size;
    }
   
    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<StandardCard> getCards() {
        return cards;
    }
    
    public StandardCard getAndRemoveTopCard() {
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
