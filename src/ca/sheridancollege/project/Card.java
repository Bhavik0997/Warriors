package ca.sheridancollege.project;
/**
 * @ author Neil-Bryan Caoile
 */

//********************************************
//             Abstract class
//********************************************

public abstract class Card {
    private Suit suit;
    private Value value;

    public Card() {
    }

    public abstract String toString();
}
