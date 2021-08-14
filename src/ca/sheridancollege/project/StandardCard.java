/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

public class StandardCard extends Card {
    private final Value value;
    private final Suit suit;

    public StandardCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public String toString() {
        return this.suit + ":" + this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Value getValue() {
        return this.value;
    }
}
