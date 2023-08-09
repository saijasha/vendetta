// A class that models a deck of playing cards package StarterCode;

import java.util.ArrayList;

public class DeckOfCards extends GroupOfCards {
    // A constructor that creates a standard 52-card deck
    public DeckOfCards() {
        super(52);
        ArrayList<Card> cards = new ArrayList<>();
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
        setCards(cards);
        shuffle();
    }

}