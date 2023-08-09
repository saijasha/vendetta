// A class that models a regular playing card package StarterCode;

public class PlayingCard extends Card {
    // The possible suits of a card
    public enum Suit {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }

    // The possible ranks of a card
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    // The suit of the card
    private Suit suit;

    // The rank of the card
    private Rank rank;

    // A constructor that takes a suit and a rank as parameters
    public PlayingCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // A getter method for the suit
    public Suit getSuit() {
        return suit;
    }

    // A getter method for the rank
    public Rank getRank() {
        return rank;
    }

    // A method that compares two cards based on their ranks
    // Returns 1 if this card has a higher rank than the other card
    // Returns -1 if this card has a lower rank than the other card
    // Returns 0 if this card has the same rank as the other card
    public int compareTo(PlayingCard other) {
        if (this.rank.ordinal() > other.rank.ordinal()) {
            return 1;
        } else if (this.rank.ordinal() < other.rank.ordinal()) {
            return -1;
        } else {
            return 0;
        }
    }

    // A method that returns a String representation of a card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}