/*
 * WarPlayer.java
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
 * A class that represents a player in the "War" card game.
 * This class extends the abstract class Player.
 */
class WarPlayer extends Player {

    private final GroupOfCards hand; // Player's hand of cards
    private int score; // Player's score

    /**
     * Constructor for creating a new WarPlayer object.
     *
     * @param name The name of the player.
     */
    public WarPlayer(String name) {
        super(name);
        hand = new GroupOfCards();
        score = 0;
    }

    /**
     * Returns the player's hand of cards.
     *
     * @return The player's hand of cards.
     */
    public GroupOfCards getHand() {
        return hand;
    }

    /**
     * Returns the player's score.
     *
     * @return The player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score to the given value.
     *
     * @param score The value to set as the player's score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Removes a card from the player's hand. If the hand is empty, returns
     * null.
     *
     * @return The removed card, or null if the hand is empty.
     */
    public Card removeCard() {
        if (hand.getCards().isEmpty()) {
            return null;
        }
        return hand.getCards().remove(0);
    }

}
