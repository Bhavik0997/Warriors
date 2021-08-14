/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

public abstract class Card {
    private Suit suit;
    private Value value;

    public Card() {
    }

    public abstract String toString();
}
