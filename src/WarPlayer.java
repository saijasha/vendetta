// A class that models a player in the war game package StarterCode;

import java.util.LinkedList;
import java.util.Queue;

public class WarPlayer extends Player {
    // The cards in the player's hand
    private Queue<PlayingCard> hand;

    // A constructor that takes a name as parameter and creates an empty hand
    public WarPlayer(String name) {
        super(name);
        hand = new LinkedList<>();
    }

    // A getter method for the hand
    public Queue<PlayingCard> getHand() {
        return hand;
    }

    // A method that adds a card to the end of the hand
    public void addCard(PlayingCard card) {
        hand.add(card);
    }

    // A method that removes and returns the first card from the hand
    public PlayingCard playCard() {
        return hand.poll();
    }

    // A method that returns the number of cards in the hand
    public int getHandSize() {
        return hand.size();
    }

    // A method that returns true if the hand is empty, false otherwise
    public boolean hasNoCards() {
        return hand.isEmpty();
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}