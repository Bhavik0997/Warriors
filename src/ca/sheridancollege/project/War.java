/**
 * @ author Neil-Bryan Caoile
 */
package ca.sheridancollege.project;


//********************************************
//     This class is the heart of the program
//********************************************
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class War extends Game {


    Scanner scanner;

    public War() {
        super("War Card Game");
        this.scanner = new Scanner(System.in);
    }


    //play method that consist the logic and the structure of the game.
    public void play() {
        System.out.println("\n******************************************************");
        System.out.println("           Welcome to " + this.getName());
        System.out.println("******************************************************\n");
        boolean isTwoPlayer = false;


        //Ask if there are two players.
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

        //Deck Creation
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        //Player1 and Player 2 Creation
        String player2Name = "Computer";//This is the ai name. If there is only one player 2nd Player name will be this.

        System.out.println("\n******************************************************");
        System.out.print("Enter player 1 name: ");
        String player1Name = this.scanner.nextLine();

        //if 2 players ask the 2nd players name.
        if (isTwoPlayer) {
            System.out.print("Enter player 2 name: ");
            player2Name = this.scanner.nextLine();
        }
        System.out.println("******************************************************\n");


        WarPlayer player1 = new WarPlayer(player1Name);
        WarPlayer player2 = new WarPlayer(player2Name);

        //This arraylist is for the currently drawn cards by the user.
        ArrayList<StandardCard> cardsCurrentlyDrawn = new ArrayList<>();

        //If the deck size is zero game end.
        //In other words if there are no more cards to be drawn.
        for(int round = 1; playingDeck.getCards().size() != 0; ++round) {
            //Show the round
            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n                     Round " + round + "! \n");
            System.out.println("\n-------------------------------------------------------");


            //Player 1 turn
            playerTurn(player1, playingDeck, cardsCurrentlyDrawn);
            //Player 2 turn
            playerTurn(player2, playingDeck, cardsCurrentlyDrawn);



            WarPlayer roundWinner = this.getRoundWinner(player1, player2);


            //If round winner is null then it is war.
            //Null happen when the value of both players currently drawn cards are equal.
            //When it is war, player have to set aside the currently drawn cards and each players have to draw another card again.
            //Cards drawn will be stored in an arraylist of Standard card called cardsCurrentlyDrawn.
            //If the the value of the current drawn cards is still equal when it is war, then they have to draw cards again until somebody win.
            //Who ever wins the round will get all the cards, the the player who won in this war round will receive more than 2 cards- this depends on how many times war happen.
            while (roundWinner == null){
                System.out.println("\n*************** !!!!ITS WAR!!!! **********************");
                System.out.println("*************** !!!!ITS WAR!!!! **********************");
                System.out.println("*************** !!!!ITS WAR!!!! **********************");

                System.out.println("            [Number of drawn cards = " + cardsCurrentlyDrawn.size() + "] " );

                playerTurn(player1, playingDeck, cardsCurrentlyDrawn);
                //Player 2 turn
                playerTurn(player2, playingDeck, cardsCurrentlyDrawn);


                roundWinner = this.getRoundWinner(player1,player2);
            }

            this.declareRoundWinner(roundWinner, cardsCurrentlyDrawn);
            this.showCardsWon(player1, player2);
        }

        this.declareWinner(player1, player2);//Declare winner
    }

    //This method consist the flow of each players turn
    public void playerTurn(WarPlayer player,Deck deck, ArrayList<StandardCard> cardsCurrentlyDrawn){

        //Show the player who should draw
        System.out.println("\n******************************************************");
        System.out.println("       Press [enter] to draw a card for " + player.getName());
        System.out.println("******************************************************");
        this.scanner.nextLine();

        //Draw
        player.draw(deck);

        //Print out the drawn card
        System.out.println(player.getName() + "'s card is: " + player.getDrawnCard());

        //Add the card currently drawn by p1 to the currentlyDrawn arraylist
        cardsCurrentlyDrawn.add(player.getDrawnCard());


    }
    //Returns the player who won the round
    public WarPlayer getRoundWinner(WarPlayer p1, WarPlayer p2) {
        WarPlayer playerRoundWinner = p2;
        System.out.println("-------------------------------------------------------");
        if (this.cardValueToInt(p1.getDrawnCard()) > this.cardValueToInt(p2.getDrawnCard())) {
            playerRoundWinner = p1;
            System.out.println("              " + p1.getDrawnCard() + " > " + p2.getDrawnCard());
        }else if(this.cardValueToInt(p1.getDrawnCard()) == this.cardValueToInt(p2.getDrawnCard())){
            playerRoundWinner = null;
            System.out.println("              " + p1.getDrawnCard() + " = " + p2.getDrawnCard());
        }
        else {
            System.out.println("              " + p2.getDrawnCard() + " > " + p1.getDrawnCard());
        }

        System.out.println("-------------------------------------------------------");
        return playerRoundWinner;
    }
    //Convert the enum value to int
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
    //Print out the ROUND winner
    public void declareRoundWinner(WarPlayer roundWinner, ArrayList<StandardCard> cardsCurrentlyDrawn) {
        System.out.println("\n******************************************************");
        System.out.println("              " + roundWinner.getName() + "  won for this round! ");
        System.out.println("          press [enter] to continue.");
        System.out.println("******************************************************\n");
        roundWinner.getCardsWon().addAll(cardsCurrentlyDrawn);
        cardsCurrentlyDrawn.clear();
        this.scanner.nextLine();
    }
    //Shows how many cards user won.
    public void showCardsWon(WarPlayer p1, WarPlayer p2) {
        System.out.println("******************************************************");
        System.out.println("               ~ Player cards won ~");
        PrintStream var10000 = System.out;
        String var10001 = p1.getName();
        var10000.println("             " + var10001 + " [" + p1.getCardsWon().size() + "] | " + p2.getName() + " [" + p2.getCardsWon().size() + "] ");
        if (p1.getCardsWon().size() > p2.getCardsWon().size()) {
            System.out.println("              ~ " + p1.getName() + " is winning!~ ");
        } else {
            System.out.println("               ~ " + p2.getName() + " is winning!~ ");
        }

        System.out.println("          press [enter] to go to next round");
        System.out.println("******************************************************\n");
        this.scanner.nextLine();
    }
    //Declare the overall winner of the game
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

    @Override
    public String getName() {
       return name;
    }
}

