/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author darre
 */
public enum Suit {
    
    SPADES ("Spades"),
    HEARTS ("Hearts"),
    CLUBS ("Clubs"),
    DIAMONDS ("Diamonds");
    
    private String displayName;
    
    public String getDisplayName() {
        return displayName;
    }
    
    private Suit(String suit) {
        displayName = suit;
    }
    
    
}
