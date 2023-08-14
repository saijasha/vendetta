import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Card card) {
        if (card != null) {
            hand.add(card);
        }
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public Card playCard() {
        if (hand.isEmpty()) {
            return null;
        }
        return hand.remove(0);
    }

    public void drawCard(List<Card> cards) {
        if (cards != null) {
            hand.addAll(cards);
        }
    }

    public int getHandSize() {
        return hand.size();
    }
}
