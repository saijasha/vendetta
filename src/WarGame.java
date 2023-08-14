
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * WarGame.java
 *
 * Team - vendetta
 *
 * @author saijasha
 * @author sin12874
 * @author paaneris
 * @author bhikadip
 *
 */

/**
 * A class that represents the "War" card game. This class extends the abstract
 * class Game.
 */
public class WarGame extends Game {

    private final GroupOfCards deck; // the deck of cards used for the game
    private boolean gameOver = false; // a flag to indicate if the game is over
    private int round = 1; // the number of rounds played in the game
    private WarPlayer winner = null; // the winner of the game

    /**
     * Constructor for creating a new WarGame object.
     *
     * @param name The name of the game.
     */
    public WarGame(String name) {
        super(name);
        deck = new GroupOfCards(52); // a standard deck has 52 cards
        initializeDeck(); // create the cards and add them to the deck
    }

    /**
     * Creates 52 cards and adds them to the deck, representing a standard deck
     * of playing cards.
     */
    public void initializeDeck() {
        String[] suits = {"clubs", "spades", "diamonds", "hearts"};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                PlayingCard card = new PlayingCard(suit, i);
                deck.getCards().add(card);
            }
        }
    }

    /**
     * A method to declare the winner of the game or determine if the game is a
     * tie.
     */
    @Override
    public void declareWinner() {
        ArrayList<WarPlayer> activePlayers = new ArrayList<>();
        int maxCards = 0; // the maximum number of cards left among the active players

        for (Player p : getPlayers()) {
            WarPlayer wp = (WarPlayer) p;
            if (!wp.getHand().getCards().isEmpty()) {
                activePlayers.add(wp);
                int numCards = wp.getHand().getCards().size();
                if (numCards > maxCards) {
                    maxCards = numCards;
                }
            }
        }

        if (activePlayers.size() == 1 || round > 35) {
            // If there is only one active player or the round limit is reached, declare the
            // winner based on the maximum number of cards.
            for (WarPlayer wp : activePlayers) {
                int numCards = wp.getHand().getCards().size();
                if (numCards == maxCards) {
                    winner = wp;
                    gameOver = true;
                    break; // Found a winner, break the loop
                }
            }

            if (!gameOver) {
                // If no winner is found (multiple players with the same max cards),
                // declare a tie.
                System.out.println("The game is a tie!");
                for (Player p : activePlayers) {
                    WarPlayer wp = (WarPlayer) p;
                    int numCards = wp.getHand().getCards().size();
                    System.out.println(wp.getName() + " has " + numCards + " cards left.");
                }
                gameOver = true;
            }
        }
    }

    /**
     * A method that distributes the deck of cards to the players.
     */
    public void dealCards() {
        deck.shuffle(); // Shuffle the deck before dealing
        int numPlayers = getPlayers().size();
        // Calculate the number of cards each player should get
        int numCards = deck.getCards().size() / numPlayers;
        for (Player p : getPlayers()) {
            WarPlayer player = (WarPlayer) p;
            for (int i = 0; i < numCards; i++) {
                Card card = deck.getCards().remove(0);
                player.getHand().getCards().add(card);
            }
        }
    }

    /**
     * A method that simulates one round of the game.
     */
    public void playRound() {
        System.out.println("\nRound " + round + ":");
        round++;
        ArrayList<Card> table = new ArrayList<>(); // A list of cards on the table
        boolean war = false; // A flag to indicate if there is a war
        int max = 0; // The maximum value of the cards on the table
        WarPlayer winner = null; // The winner of the round

        // Each player plays a card and puts it on the table
        for (Player p : getPlayers()) {
            WarPlayer wp = (WarPlayer) p;
            Card card = wp.removeCard();
            if (card == null) {
                System.out.println(wp.getName() + " has no more cards and is out of the game.");
                continue; // Skip this player
            }
            System.out.println(wp.getName() + " plays " + card);
            table.add(card);
            int value = ((PlayingCard) card).getValue();
            if (value > max) {
                max = value;
                winner = wp;
                war = false;
            } else if (value == max) {
                war = true;
            }
        }

        // If there is a war, each player plays three more cards and
        // puts them on the table
        if (war) {
            System.out.println("War!");
            for (Player p : getPlayers()) {
                WarPlayer wp = (WarPlayer) p;
                for (int i = 0; i < 3; i++) {
                    Card card = wp.removeCard();
                    if (card == null) {
                        System.out.println(wp.getName()
                                + " has no more cards and is out of the game.");
                        break;
                    }
                    System.out.println(wp.getName() + " plays " + card);
                    table.add(card);
                    int value = ((PlayingCard) card).getValue();
                    if (value > max) {
                        max = value;
                        winner = wp;
                        war = false;
                    } else if (value == max) {
                        war = true;
                    }
                }
            }
        }

        // If there is still a war, declare a tie and discard all cards on the table
        if (war) {
            System.out.println("Tie! All cards on the table are discarded.");
            table.clear();
        } else {
            // Otherwise, declare the winner and give them all cards on the table
            System.out.println(winner.getName() + " wins this round and gets "
                    + table.size() + " cards.");
            winner.getHand().getCards().addAll(table);
            winner.setScore(winner.getScore() + table.size());
            table.clear();
        }

        // Show each player's number of cards left after this round
        for (Player p : getPlayers()) {
            WarPlayer wp = (WarPlayer) p;
            System.out.println(wp.getName() + " has "
                    + wp.getHand().getCards().size() + " cards left.");
        }
    }

    /**
     * A method that asks for user input to continue or quit the game. And also
     * declares a winner if user quits.
     */
    public void askUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue or q to quit.");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("q")) {
            System.out.println("You have quit the game.");
            if (!gameOver) { // Update the winner only if the game is not over
                ArrayList<WarPlayer> activePlayers = new ArrayList<>();
                int maxCards = 0;
                for (Player p : getPlayers()) {
                    WarPlayer wp = (WarPlayer) p;
                    int numCards = wp.getHand().getCards().size();
                    if (numCards > maxCards) {
                        activePlayers.clear();
                        activePlayers.add(wp);
                        maxCards = numCards;
                    } else if (numCards == maxCards) {
                        activePlayers.add(wp);
                    }
                }
                if (!activePlayers.isEmpty()) {
                    winner = activePlayers.get(0);
                } else {
                    System.out.println("The game is a tie!");
                }
                gameOver = true;
            }
        }
    }

    /**
     * Starts and manages the "War" card game. This method handels the setup,
     * gameplay, and printing the winner of the game.
     */
    @Override
    public void play() {
        // Deal the cards to the players
        dealCards();

        // Play rounds until the game is over or the user quits
        while (!gameOver) {
            playRound();
            declareWinner();
            if (!gameOver) {
                askUserInput();
            }
        }

        // Print final results
        System.out.println("\nGame Over!");

        if (winner != null && gameOver == true) {
            System.out.println(
                    winner.getName() + " has won the game with "
                    + winner.getHand().getCards().size() + " cards left!");
        } else {
            System.out.println("The game is a tie!");
        }

        // Print each player's final score
        for (Player p : getPlayers()) {
            WarPlayer wp = (WarPlayer) p;
            System.out.println(wp.getName() + "'s final score: " + wp.getScore());
        }
    }
}
