public class Card {
    private String suit;
    private int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String cardValue;
        switch (value) {
            case 1:
                cardValue = "Ace";
                break;
            case 11:
                cardValue = "Jack";
                break;
            case 12:
                cardValue = "Queen";
                break;
            case 13:
                cardValue = "King";
                break;
            default:
                cardValue = Integer.toString(value);
        }
        return cardValue + " of " + suit;
    }
}
