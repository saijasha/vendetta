import java.util.ArrayList;

public abstract class Game<T extends Player> {
    private final String name;
    private ArrayList<T> players;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<T> players) {
        this.players = players;
    }

    public abstract void play();

    public abstract void declareWinner();
}
