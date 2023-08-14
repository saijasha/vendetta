import java.util.ArrayList;

public class WarGame {
    private final Player player1;
    private final Player player2;
    private final Deck deck;

    public WarGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        deck = new Deck();
    }

    public void start() {
        System.out.println("Starting the War card game!");

        // Shuffle the deck
        deck.shuffle();

        // Deal cards to players
        dealCards();

        // Start the game
        playGame();
    }

    private void playGame() {
        System.out.println("Let the game begin!");

        while (player1.hasCards() && player2.hasCards()) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            if (card1.getValue() > card2.getValue()) {
                player1.drawCard(card2);
                System.out.println(player1.getName() + " wins the round!");
            } else if (card1.getValue() < card2.getValue()) {
                player2.drawCard(card1);
                System.out.println(player2.getName() + " wins the round!");
            } else {
                System.out.println("It's a tie! Starting a war...");
                performWar();
            }

            System.out.println(player1.getName() + " has " + player1.getHandSize() + " cards.");
            System.out.println(player2.getName() + " has " + player2.getHandSize() + " cards.");
            System.out.println();
        }

        // Determine the winner
        determineWinner();
    }

    private void dealCards() {
        while (!deck.isEmpty()) {
            player1.drawCard(deck.drawCard());
            player2.drawCard(deck.drawCard());
        }
    }

    private void performWar() {
        // Handle the war logic
    }

    private void determineWinner() {
        // Determine and display the winner of the game
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame("Player 1", "Player 2");
        warGame.start();
    }
}
O code application logic here
    }
    
}
