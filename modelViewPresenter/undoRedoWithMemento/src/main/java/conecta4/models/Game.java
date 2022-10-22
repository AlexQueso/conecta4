package conecta4.models;

import conecta4.types.Color;

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
        turn.prepareTurn();
    }

    public void putToken(int column) {
        board.putToken(column, turn.getColorActivePlayer());
    }

}
