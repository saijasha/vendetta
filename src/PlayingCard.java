/*
 *
 * PlayingCard.java
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
 * A class that models a playing card.
 * This class extends the abstract class Card.
 */
public class PlayingCard extends Card {

    private final String suit; // clubs, spades, diamonds, hearts
    private final int value; // 1-13

    /**
     * Constructor for creating a new PlayingCard object.
     *
     * @param suit The suit of the card (e.g., clubs, spades, diamonds, hearts).
     * @param value The value of the card (an integer between 1 and 13).
     */
    public PlayingCard(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Get the suit of the playing card.
     *
     * @return The suit of the card (e.g., clubs, spades, diamonds, hearts).
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Get the value of the playing card.
     *
     * @return The value of the card (an integer between 1 and 13).
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a String representation of the playing card.
     *
     * @return A String representation of the playing card in the format
     * "PlayingCard{suit=value}".
     */
    @Override
    public String toString() {
        // return "PlayingCard{" + "suit=" + suit + ", value=" + value + '}';
        return "Card { " + value + " of " + suit + " }";
    }
}
