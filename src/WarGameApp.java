
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*
 * WarGameApp.java
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
 * The main class that contains the main method to run the "War" card game.
 */
public class WarGameApp {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;

    /**
     * The main method that starts the "War" card game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the War card game!");

        // Create a new instance of the WarGame class
        WarGame game = new WarGame("War");

        int numPlayers = 0;

        // Asking user input for number of players untill correct value is inserted
        do {
            // Prompt the user for the number of players in the game
            System.out.print("How many players are in this game? (2-4): ");
            try {
                numPlayers = Integer.parseInt(sc.nextLine());
                if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
                    System.out.println("Please enter correct number of players!");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number between 2 and 4.");
                numPlayers = 0; // set numPlayers to 0 to continue the loop
            }
        } while (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS || numPlayers == 0);

        // Create and add players to the game
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            String name = sc.nextLine();
            // Use regex to validate name
            String regex = "^[A-Za-z ]+$"; // Define the regex pattern
            boolean isValid = name.matches(regex); // Test if name matches the regex
            // If name is not valid, ask the user to enter a valid name
            while (!isValid) {
                System.out.println("Invalid name. Please enter a name that contains only letters and spaces.");
                System.out.print("Enter the name of player " + (i + 1) + ": ");
                name = sc.nextLine();
                isValid = name.matches(regex); // Test again
            }
            WarPlayer player = new WarPlayer(name);
            game.getPlayers().add(player);
        }

        // Start the game by invoking the play method
        game.play();
    }
}