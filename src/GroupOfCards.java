
import java.util.ArrayList;
import java.util.Collections;

/*
 * GroupOfCards.java
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
 * A class that represents a group of playing cards.
 */
class GroupOfCards {

    private final ArrayList<Card> cards; // ArrayList to hold the cards in the group

    /**
     * Default constructor. Creates an empty group of cards.
     */
    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    /**
     * Constructor with initial capacity. Creates an empty group of cards with
     * the specified size.
     *
     * @param deckSize The deck size of the group of cards.
     */
    public GroupOfCards(int deckSize) {
        cards = new ArrayList<>(deckSize);
    }

    /**
     * Get the list of cards in the group.
     *
     * @return The ArrayList containing the cards in the group.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Add a card to the group of cards.
     *
     * @param card The card to be added to the group.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Shuffle the group of cards. This method randomly rearranges the order of
     * cards in the group.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
}