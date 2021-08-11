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
import java.util.ArrayList;
public class WarPlayer extends Player {
    
    private GroupOfCards playingCards;
    public StandardCard topCard;
    
    // 
    public StandardCard getTopCard() {
        this.topCard = playingCards.getAndRemoveTopCard();
        return topCard;
        //return playingCards.getCards().get(0);
    }
    
    public WarPlayer(String name, GroupOfCards groupOfCards) {
        super(name);
        this.playingCards = groupOfCards;
    }
    

   // not used 
    public GroupOfCards playingCards(int i){
        i = 26;
        return this.playingCards(i);
    }
    
    public int getHandSize() {
        return playingCards.getSize();
    }
    
    public ArrayList<StandardCard> hand() {
        return playingCards.getCards();
    }
    
   
        
    
    
}
