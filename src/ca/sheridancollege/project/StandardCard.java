/**
 * @ author Neil-Bryan Caoile
 */
package ca.sheridancollege.project;
//********************************************
//     This class imitates Standard cards
//       Contains enum Suits and Values
//********************************************
public class StandardCard extends Card {

    public StandardCard(Suit suit, Value value) {
        super.suit = suit;
        super.value = value;
    }

    //Print out the card's information- value and suit
    public String toString() {
        return this.suit + ":" + this.value;
    }
    //Get the value of the card
    public Value getValue() {
        return this.value;
    }
}
