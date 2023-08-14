
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*
 * Game.java
 *
 * Team - vendetta
 *
 * @author saijasha
 * @author sin12874
 * @author paaneris
 * @author bhikadip
 *
 */

/**
 * The abstract class that models a game. You should create a more specific
 * child of this class and instantiate the methods given.
 */
public abstract class Game {

    private final String name; // the title of the game
    private ArrayList<Player> players; // the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    /**
     * @return the name of the game
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the players of this game.
     *
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();

}