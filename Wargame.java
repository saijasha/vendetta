public class Wargame {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        Deck deck = new Deck();

        // Distribute cards to players
        while (deck.drawCard() != null) {
            player1.addCardToHand(deck.drawCard());
            player2.addCardToHand(deck.drawCard());
        }

        int round = 1;
        while (player1.hasCards() && player2.hasCards()) {
            System.out.println("Round " + round);
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            int compareValue = card1.getRank().compareTo(card2.getRank());

            if (compareValue > 0) {
                System.out.println(player1.getName() + " wins the round!");
                player1.addCardToHand(card1);
                player1.addCardToHand(card2);
            } else if (compareValue < 0) {
                System.out.println(player2.getName() + " wins the round!");
                player2.addCardToHand(card1);
                player2.addCardToHand(card2);
            } else {
                System.out.println("It's a tie! Prepare for WAR!");
                // Code for the "war" scenario goes here
            }

            round++;
        }

        if (player1.hasCards()) {
            System.out.println(player1.getName() + " wins the game!");
        } else {
            System.out.println(player2.getName() + " wins the game!");
        }
    }
}
