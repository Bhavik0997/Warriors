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
import java.util.Scanner;

public class WarGame extends Game {
    
    WarPlayer player1;
    WarPlayer player2;

    Scanner input = new Scanner(System.in);
    
    public WarGame(String name) {
        super("War");
    }  
    
    public void play() {
        
        // create decks
        GroupOfCards deck1 = new GroupOfCards(52);
        GroupOfCards deck2 = new GroupOfCards(52);
        
        // prompt for user input
        System.out.print("Enter player 1's name: ");
            player1 = new WarPlayer(input.nextLine(), deck1);
        
        System.out.print("Is there a second player? Answer: (y/n)");
        char numPlayers = input.nextLine().charAt(0);
        
        if (numPlayers == 'y') {    
            System.out.print("Enter player 2's name: ");
            player2 = new WarPlayer(input.nextLine(), deck2);
        }
        
        else {
            player2 = new WarPlayer("AI", deck2);
        } 
        
        System.out.println("This game of War is between " + player1.getName() + " versus " + player2.getName() + "!");
        
        // do-while loop that exits when HandSize is 0
        do {
            // prompt
            System.out.print("Press any key to draw!\nNote: " + player1.getName() + " has " + player1.getHandSize() + " cards;  " + player2.getName() + " has " + player2.getHandSize() + "\n");
            input.nextLine();
            
            // draw and state output

            System.out.print(player1.getName() + " draws a " + player1.getTopCard().toString() + "\n");

            System.out.print(player2.getName() + " draws a " + player2.getTopCard().toString() + "\n");
            
            // compare values of cards
            if (player1.topCard.getValue().getCardValue() > player2.topCard.getValue().getCardValue()) {
                
                // supposed to add elements to arraylist; doesn't?
                player1.hand().add(player1.topCard);
                player1.hand().add(player2.topCard);
                
                // supposed to remove elements from arraylist; doesn't?
                player2.hand().remove(player1.topCard);
                player2.hand().remove(player2.topCard);
                
                System.out.print(player1.getName() + " has the higher card and wins the hand!\n");
                        
            } else if (player2.topCard.getValue().getCardValue() > player1.topCard.getValue().getCardValue()) {
                
                // supposed to add elements to arraylist; doesn't?
                player2.hand().add(player2.topCard);
                player2.hand().add(player1.topCard);
                
                // supposed to remove elements from arraylist; doesn't?
                player1.hand().remove(player1.topCard);
                player1.hand().remove(player2.topCard);
                
                System.out.print(player2.getName() + " has the higher card and wins the hand!\n");
                
            } else {
                
                // war begins
                // initialize sidePool 
                ArrayList<StandardCard> sidePool = new ArrayList<>();
    
                    // add existing and top cards to sidePool
                    sidePool.add(player1.topCard);
                    sidePool.add(player2.topCard);
                    
                    // these are the two face-down cards
                    sidePool.add(player1.getTopCard());
                    sidePool.add(player2.getTopCard());
                
                do { 
                    
                    // prompt user that war is beginning
                    System.out.print("It's a tie! War begins!");
                    
                    // check to make sure that users have sufficient number of cards
                    if (player1.getHandSize() > 1 || player2.getHandSize() > 1) {
                        
                        System.out.print("Press any key to draw!");
                        input.nextLine();
                        
                        // draw again
                        sidePool.add(player1.getTopCard());
                        sidePool.add(player2.getTopCard());
                        
                        System.out.print(player1.getName() + " draws a " + player1.topCard.toString());
                        
                        System.out.print(player2.getName() + " draws a " + player2.topCard.toString());

                        // compare again; not set up to do a second war yet
                        if (player1.topCard.getValue().getCardValue() > player2.topCard.getValue().getCardValue()) {

                            player1.hand().addAll(sidePool);
                            System.out.print(player1.getName() + " has the higher card and wins the war!");    
                            break;
                            
                        } else //this should be implemented with an else-if, with the final "else" being another War. If (player2.topCard.getValue().getCardValue() > player1.topCard.getValue().getCardValue()) 
                        {

                            player2.hand().addAll(sidePool);
                            System.out.print(player2.getName() + " has the higher card and wins the war!");
                            break;
                        }    
                    } 
                    
                } while (player1.topCard.getValue().getCardValue() != player2.topCard.getValue().getCardValue());
            }
            
            
        } while (player2.getHandSize() >= 0 || player1.getHandSize() >= 0);
    }
    
    // not yet implemented
    public void declareWinner() {
        System.out.print("WE WON");
    }
            
            
    
}
