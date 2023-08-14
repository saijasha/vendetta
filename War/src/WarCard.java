class WarCard extends Card {
    private final String rank;
    private final String suit;

    public WarCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}