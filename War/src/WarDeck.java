class WarDeck extends GroupOfCards {
    public WarDeck(int size) {
        super(size);
        for (String suit : new String[] { "Hearts", "Diamonds", "Clubs", "Spades" }) {
            for (String rank : new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King",
                    "Ace" }) {
                getCards().add(new WarCard(rank, suit));
            }
        }
    }
}