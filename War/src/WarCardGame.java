import java.util.ArrayList;
import java.util.Scanner;

public class WarCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of players
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        ArrayList<WarPlayer> players = new ArrayList<>(); // Use ArrayList<WarPlayer>
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String playerName = scanner.nextLine();
            players.add(new WarPlayer(playerName));
        }

        WarGame warGame = new WarGame("War Card Game");
        warGame.setPlayers(players);
        warGame.play();
    }
}
