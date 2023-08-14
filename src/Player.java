/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*
 * Player.java
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
 * An abstract class that models each Player in the game. Players have an
 * identifier, which should be unique.
 */
public abstract class Player {

    private String name; // the unique name for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}