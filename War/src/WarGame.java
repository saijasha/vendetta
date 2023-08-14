import java.util.Scanner;

class WarGame extends Game<WarPlayer> {
    private WarDeck deck;
    private final int maxRounds = 35;
    private WarPlayer roundWinner;

    public WarGame(String name) {
        super(name);
        deck = new WarDeck(52);
    }

    private void deal() {
        deck.shuffle();
        int playerCount = getPlayers().size();
        int cardIndex = 0;
        for (int i = 0; i < 52; i++) {
            WarPlayer player = (WarPlayer) getPlayers().get(i % playerCount);
            player.getHand().add((WarCard) deck.getCards().get(cardIndex));
            cardIndex++;
        }
    }

    private void playRound() {
        roundWinner = null;
        WarCard highestCard = null;

        // Check if any player has no cards left
        for (WarPlayer player : getPlayers()) {
            if (player.getHand().isEmpty()) {
                declareWinner();
                return;
            }
        }

        for (WarPlayer player : getPlayers()) {
            if (player.getHand().isEmpty()) {
                continue;
            }

            WarCard topCard = player.getHand().remove(0);
            System.out.println(player.getName() + " plays " + topCard);

            if (highestCard == null || compareCards(topCard, highestCard) > 0) {
                highestCard = topCard;
                roundWinner = player;
            } else if (compareCards(topCard, highestCard) == 0) {
                roundWinner = null; // War
            }
        }

        if (roundWinner != null) {
            System.out.println(roundWinner.getName() + " wins the round.");
            roundWinner.getHand().add(highestCard);
            roundWinner.incrementRoundsWon(); // Increment rounds won for the winner
        } else {
            System.out.println("It's a tie! War starts!");
            for (WarPlayer player : getPlayers()) {
                if (!player.getHand().isEmpty()) {
                    player.getHand().remove(0); // Discard one card for War
                }
            }
            playRound(); // Recursive call to handle War
        }
    }

    private int compareCards(WarCard card1, WarCard card2) {
        // Compare ranks of cards
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        int rank1 = 0, rank2 = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (card1.toString().startsWith(ranks[i])) {
                rank1 = i;
            }
            if (card2.toString().startsWith(ranks[i])) {
                rank2 = i;
            }
        }
        return Integer.compare(rank1, rank2);
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        // Number of players
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        // Player names
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String playerName = scanner.nextLine();
            getPlayers().add(new WarPlayer(playerName));
        }

        // Deal cards
        deal();

        // Game rounds
        int round = 1;
        while (round <= maxRounds) {
            System.out.println("\nRound " + round);
            System.out.println("Press Enter to continue or 'q' to quit the game.");

            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("q")) {
                break;
            }

            System.out.println("\n**********");
            System.out.println("Round " + round + " starts.");
            playRound();

            round++;
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        WarPlayer winner = (WarPlayer) getPlayers().get(0);
        for (Player player : getPlayers()) {
            if (((WarPlayer) player).getRoundsWon() > winner.getRoundsWon()) {
                winner = (WarPlayer) player;
            }
        }
        System.out.println("\nGame over!");
        if (winner.getRoundsWon() == 0) {
            System.out.println("It's a tie!");
        } else {
            System.out.println(winner.getName() + " wins the game!");
        }
    }

}