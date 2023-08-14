import java.util.ArrayList;

class WarPlayer extends Player {
    private ArrayList<WarCard> hand;
    private int roundsWon;

    public WarPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        roundsWon = 0;
    }

    public ArrayList<WarCard> getHand() {
        return hand;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void incrementRoundsWon() {
        roundsWon++;
    }

    @Override
    public void play() {
        // Nothing to do here for War game. The game logic will be implemented in the
        // Game class.
    }
}
