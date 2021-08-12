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
public enum Value {
    
    ACE ("Ace", 14),
    KING ("King", 13),
    QUEEN ("Queen", 12),
    JACK ("Jack", 11),
    TEN ("Ten", 10),
    NINE ("Nine", 9),
    EIGHT ("Eight", 8),
    SEVEN ("Seven", 7),
    SIX ("Six", 6),
    FIVE ("Five", 5),
    FOUR ("Four", 4),
    THREE ("Three", 3),
    TWO ("Two", 2);
    
    private String displayName;
    private int cardValue;
    
    public String getDisplayName() {
        return displayName;
    }
    
    public int getCardValue() {
        return cardValue;
    }
    
    private Value(String name, int value) {
        displayName = name;
        cardValue = value;
    }
    
}
