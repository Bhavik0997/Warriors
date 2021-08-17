/**
 * @ author Neil-Bryan Caoile
 */
package ca.sheridancollege.project;

//********************************************
//             Abstract class
//********************************************
public abstract class Player {
    private final String name;
    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

