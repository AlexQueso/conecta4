package connect4.models;

import connect4.types.Color;
import org.apache.commons.lang.SerializationUtils;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public Color getColor(Coordinate coordinate) {
        return board.getColor(coordinate);
    }

    public boolean isColumnFull(int column) {
        return board.isColumnFull(column);
    }

    public void next() {
        turn.toggleActivePlayer();
    }

    public boolean isTie() {
        return turn.isTie();
    }

    public boolean isGameOver() {
        return turn.isGameOver();
    }

    public Color getActivePlayer() {
        return turn.getColorActivePlayer();
    }

    public void reset() {
        board.reset();
        turn.reset();
    }

    public void putToken(int column) {
        turn.putToken(column);
    }

    public Board boardPicture() {
        return (Board) SerializationUtils.clone(this.board);
    }

    public void setMemento(Memento memento) {
        this.board = memento.getBoard();
        this.turn = new Turn(this.board);
        this.turn.setActivePlayer(memento.getActivePlayer());
    }
}
