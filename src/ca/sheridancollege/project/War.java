/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class War extends Game {
    Scanner scanner;

    public War() {
        super("War Card Game");
        this.scanner = new Scanner(System.in);
    }


    public void play() {
        System.out.println("\n******************************************************");
        System.out.println("           Welcome to " + super.getName());
        System.out.println("******************************************************\n");
        boolean isTwoPlayer = false;

        while(true) {
            System.out.print("Is there two players? (y/n): ");
            char input = this.scanner.next().toLowerCase().charAt(0);
            this.scanner.nextLine();
            if (input == 'y') {
                isTwoPlayer = true;
                break;
            }

            if (input == 'n') {
                break;
            }

            System.out.println("Invalid input please try again.");
        }

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        String player2Name = "Computer";
        System.out.println("\n******************************************************");
        System.out.print("Enter player 1 name: ");
        String player1Name = this.scanner.nextLine();
        if (isTwoPlayer) {
            System.out.print("Enter player 2 name: ");
            player2Name = this.scanner.nextLine();
        }

        System.out.println("******************************************************\n");
        WarPlayer player1 = new WarPlayer(player1Name);
        WarPlayer player2 = new WarPlayer(player2Name);
        ArrayList<StandardCard> cardsCurrentlyDrawn = new ArrayList();

        for(int round = 1; playingDeck.getCards().size() != 0; ++round) {
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n                     Round " + round + "! \n");
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n******************************************************");
            System.out.println("       Press [enter] to draw a card for " + player1.getName());
            System.out.println("******************************************************");
            this.scanner.nextLine();
            player1.draw(playingDeck);
            PrintStream var10000 = System.out;
            String var10001 = player1.getName();
            var10000.println(var10001 + "'s card is: " + player1.getDrawnCard());
            cardsCurrentlyDrawn.add(player1.getDrawnCard());
            System.out.println("\n******************************************************");
            System.out.println("        Press [enter] to draw a card for " + player2.getName());
            System.out.println("*******************************************************");
            this.scanner.nextLine();
            player2.draw(playingDeck);
            var10000 = System.out;
            var10001 = player2.getName();
            var10000.println(var10001 + "'s card is: " + player2.getDrawnCard());
            cardsCurrentlyDrawn.add(player2.getDrawnCard());
            System.out.println("\n******************************************************");
            System.out.println("             Press [enter] to compare");
            System.out.println("******************************************************\n");
            this.scanner.nextLine();
            WarPlayer roundWinner = this.getRoundWinner(player1, player2);
            this.declareRoundWinner(roundWinner, cardsCurrentlyDrawn);
            this.showCardsWon(player1, player2);
        }

        this.declareWinner(player1, player2);
    }

    public WarPlayer getRoundWinner(WarPlayer p1, WarPlayer p2) {
        WarPlayer playerRoundWinner = p2;
        System.out.println("-------------------------------------------------------");
        PrintStream var10000;
        StandardCard var10001;
        if (this.cardValueToInt(p1.getDrawnCard()) > this.cardValueToInt(p2.getDrawnCard())) {
            playerRoundWinner = p1;
            var10000 = System.out;
            var10001 = p1.getDrawnCard();
            var10000.println("              " + var10001 + " > " + p2.getDrawnCard());
        } else {
            var10000 = System.out;
            var10001 = p2.getDrawnCard();
            var10000.println("              " + var10001 + " > " + p1.getDrawnCard());
        }

        System.out.println("-------------------------------------------------------");
        return playerRoundWinner;
    }

    public int cardValueToInt(StandardCard card) {
        int value = 0;
        switch(card.getValue()) {
            case TWO:
                value = 2;
                break;
            case THREE:
                value = 3;
                break;
            case FOUR:
                value = 4;
                break;
            case FIVE:
                value = 5;
                break;
            case SIX:
                value = 6;
                break;
            case SEVEN:
                value = 7;
                break;
            case EIGHT:
                value = 8;
                break;
            case NINE:
                value = 9;
                break;
            case TEN:
                value = 10;
                break;
            case JACK:
                value = 11;
                break;
            case KING:
                value = 12;
                break;
            case QUEEN:
                value = 13;
                break;
            case ACE:
                value = 14;
        }

        return value;
    }

    public void declareRoundWinner(WarPlayer roundWinner, ArrayList<StandardCard> cardsCurrentlyDrawn) {
        System.out.println("\n******************************************************");
        System.out.println("              " + roundWinner.getName() + "  won for this round! ");
        System.out.println("          press [enter] to continue.");
        System.out.println("******************************************************\n");
        roundWinner.getCardsWon().addAll(cardsCurrentlyDrawn);
        cardsCurrentlyDrawn.clear();
        this.scanner.nextLine();
    }

    public void showCardsWon(WarPlayer p1, WarPlayer p2) {
        System.out.println("******************************************************");
        System.out.println("               ~ Player cards won ~");
        PrintStream var10000 = System.out;
        String var10001 = p1.getName();
        var10000.println("             n" + var10001 + " [" + p1.getCardsWon().size() + "] | " + p2.getName() + " [" + p2.getCardsWon().size() + "] ");
        if (p1.getCardsWon().size() > p2.getCardsWon().size()) {
            System.out.println("              ~ " + p1.getName() + " is winning!~ ");
        } else {
            System.out.println("               ~ " + p2.getName() + " is winning!~ ");
        }

        System.out.println("          press [enter] to go to next round");
        System.out.println("******************************************************\n");
        this.scanner.nextLine();
    }

    public void declareWinner(WarPlayer p1, WarPlayer p2) {
        System.out.println("******************************************************\n");
        System.out.println("________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_______¶¶¶¶ \n¶¶¶_______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________¶¶¶ \n¶¶¶____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____¶¶¶¶ \n_¶¶¶___¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶____¶¶¶ \n___¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶ \n______¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶___¶¶¶¶¶¶ \n_______________¶¶¶¶¶¶¶¶¶¶¶¶ \n_________________¶¶¶¶¶¶¶¶ \n___________________¶¶¶¶ \n___________________¶¶¶¶ \n_______________¶¶¶¶¶¶¶¶¶¶¶¶ \n____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n____________¶¶¶____________¶¶¶ \n____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n");
        if (p1.getCardsWon().size() > p2.getCardsWon().size()) {
            System.out.println("            Congratulations " + p1.getName() + " won!");
        } else if (p1.getCardsWon().size() < p2.getCardsWon().size()) {
            System.out.println(p2.getName() + " won!");
        } else {
            System.out.println("DRAW!");
        }

        System.out.println("\n******************************************************");
    }
}

