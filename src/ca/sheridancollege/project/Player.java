/**
 * @ author Neil-Bryan Caoile
 */
package ca.sheridancollege.project;

//********************************************
//             Abstract class
//********************************************
public abstract class Player {
    final String name;
    public Player(String name) {
        this.name = name;
    }
    public abstract String getName();
}

