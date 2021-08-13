package ca.sheridancollege.project;
public abstract class Card {
    //default modifier for child classes


    private Suit suit;
    private Value value;


    @Override
    public abstract String toString();

}
