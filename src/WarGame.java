// A class that models the war game package StarterCode;

import java.util.ArrayList;
import java.util.Scanner;

public class WarGame extends Game {
    // The deck of cards used in the game
    private DeckOfCards deck;

    // The number of players in the game
    private int numPlayers;

    // The scanner object for user input
    private Scanner input;

    // The maximum number of rounds allowed in the game
    private final int MAX_ROUNDS = 35;

    // A constructor that takes a name as parameter and creates a new deck and
    // scanner object
    public WarGame(String name) {
        super(name);
        deck = new DeckOfCards();
        input = new Scanner(System.in);
    }

    // A method that initializes the game by asking for the number of players and
    // their names,
    // and then dealing cards to each player evenly from the deck.
    public void initializeGame() {

        System.out.println("Welcome to " + getName() + "!");

        do {
            System.out.print("Enter the number of players (2-4): ");
            numPlayers = input.nextInt();
            input.nextLine(); // consume newline character

            if (numPlayers < 2 || numPlayers > 4) {
                System.out.println("Invalid number of players. Please try again.");
            }
        } while (numPlayers < 2 || numPlayers > 4);

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String name = input.nextLine();
            players.add(new WarPlayer(name));
        }

        setPlayers(players);

        System.out.println("Dealing cards...");

        int cardsPerPlayer = deck.getSize() / numPlayers;

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                WarPlayer warPlayer = (WarPlayer) player;
                warPlayer.addCard((PlayingCard) deck.getCards().get(i * numPlayers + players.indexOf(player)));
            }
        }

        System.out.println("Cards dealt. Let the game begin!");
    }

    // A method that plays the game by looping through rounds until one player has
    // all the cards or the maximum rounds is reached
    public void play() {

        initializeGame();

        int round = 1;

        while (round <= MAX_ROUNDS) {

            System.out.println("\nRound " + round + ":");

            ArrayList<PlayingCard> cardsInPlay = new ArrayList<>();

            for (Player player : getPlayers()) {
                WarPlayer warPlayer = (WarPlayer) player;
                if (warPlayer.hasNoCards()) {
                    continue;
                }
                System.out.print(warPlayer.getName() + " plays ");
                PlayingCard card = warPlayer.playCard();
                System.out.println(card);
                cardsInPlay.add(card);
            }

            int maxIndex = 0;
            int maxRank = cardsInPlay.get(0).getRank().ordinal();

            for (int i = 1; i < cardsInPlay.size(); i++) {
                int rank = cardsInPlay.get(i).getRank().ordinal();
                if (rank > maxRank) {
                    maxIndex = i;
                    maxRank = rank;
                }
            }

            boolean isTie = false;

            for (int i = 0; i < cardsInPlay.size(); i++) {
                if (i != maxIndex && cardsInPlay.get(i).getRank().ordinal() == maxRank) {
                    isTie = true;
                    break;
                }
            }

            if (isTie) {
                System.out.println("It's a tie! The cards go to the war pile.");
            } else {
                WarPlayer winner = (WarPlayer) getPlayers().get(maxIndex);
                System.out.println(winner.getName() + " wins the round and gets all the cards!");
                for (PlayingCard card : cardsInPlay) {
                    winner.addCard(card);
                }
            }

            for (Player player : getPlayers()) {
                WarPlayer warPlayer = (WarPlayer) player;
                System.out.println(warPlayer.getName() + " has " + warPlayer.getHandSize() + " cards left.");
            }

            boolean isGameOver = false;

            for (Player player : getPlayers()) {
                WarPlayer warPlayer = (WarPlayer) player;
                if (warPlayer.getHandSize() == deck.getSize()) {
                    isGameOver = true;
                    break;
                }
            }

            if (isGameOver) {
                break;
            }

            System.out.print("\nPress enter to continue or q to quit: ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                break;
            }

            round++;
        }

        input.close();

    }

    public void declareWinner() {

        System.out.println("\nGame over!");

        int maxIndex = 0;
        int maxCards = ((WarPlayer) getPlayers().get(0)).getHandSize();

        for (int i = 1; i < getPlayers().size(); i++) {
            int cards = ((WarPlayer) getPlayers().get(i)).getHandSize();
            if (cards > maxCards) {
                maxIndex = i;
                maxCards = cards;
            }
        }

        boolean isTie = false;

        for (int i = 0; i < getPlayers().size(); i++) {
            if (i != maxIndex && ((WarPlayer) getPlayers().get(i)).getHandSize() == maxCards) {
                isTie = true;
                break;
            }
        }

        if (isTie) {
            System.out.println("It's a tie! No one wins the game.");
        } else {
            WarPlayer winner = (WarPlayer) getPlayers().get(maxIndex);
            System.out.println(winner.getName() + " wins the game with " + winner.getHandSize() + " cards!");
        }

    }

    // The main method
    public static void main(String[] args) {

        // Create an object of the WarGame class with the name "War"
        WarGame game = new WarGame("War");

        // Call the play method on the game object to start the game
        game.play();

        // Call the declareWinner method on the game object to announce the result
        game.declareWinner();

    }
}