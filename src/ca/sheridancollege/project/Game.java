package ca.sheridancollege.project;
/**
 * @ author Neil-Bryan Caoile
 */

import java.util.ArrayList;


//********************************************
//             Abstract class
//********************************************
public abstract class Game {
    final String name;
    ArrayList<Player> players;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public abstract String getName();
    public abstract void play();
}
