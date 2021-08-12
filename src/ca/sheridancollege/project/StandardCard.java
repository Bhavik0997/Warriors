/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Darren Scarfo Aug 2021
 */
public class StandardCard extends Card {

    private Suit suit;
    private Value value;    
    
    public StandardCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }

    
    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
