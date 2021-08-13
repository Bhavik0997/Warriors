package ca.sheridancollege.project;


public class StandardCard extends Card{
    private Suit suit;
    private Value value;

    public StandardCard(Suit suit, Value value){
        this.value = value;
        this.suit = suit;
    }

    public String toString(){
        return this.suit.toString() + "-" + this.value.toString();
    }

    public Value getValue(){
        return this.value;
    }
}
