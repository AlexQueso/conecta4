package connect4.models;

public class Memento {

    private final Board board;

    private final int activePlayer;

    public Memento(Game game) {
        this.board = game.boardPicture();
        this.activePlayer = game.getActivePlayer().ordinal();
    }

    public Board getBoard() {
        return board;
    }

    public int getActivePlayer() {
        return activePlayer;
    }
}
