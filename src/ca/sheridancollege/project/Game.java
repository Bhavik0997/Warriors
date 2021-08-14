package ca.sheridancollege.project;
/**
 * @ author Neil-Bryan Caoile
 */

import java.util.ArrayList;


//********************************************
//             Abstract class
//********************************************
public abstract class Game {
    private final String name;
    private ArrayList<Player> players;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList();
    }

    public String getName() {
        return this.name;
    }
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    //This method consist the game.
    public abstract void play();
}
