package ca.sheridancollege.project;
/**
 * @ author Neil-Bryan Caoile
 */

//********************************************
//             Abstract class
//********************************************

public abstract class Card {
     Suit suit;
     Value value;

    public Card() {
    }

    public abstract String toString();
}
