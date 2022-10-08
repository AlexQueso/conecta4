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

    public boolean isColumnFull(Coordinate coordinate) {
        return board.isColumnFull(coordinate);
    }

    public Coordinate putToken(Coordinate coordinate) {
        return board.putToken(coordinate, turn.getColorActivePlayer());
    }

    public void addTokenToPlayerGoals(Coordinate newTokenCoordinate) {
        turn.addTokenToGoals(newTokenCoordinate);
    }

    public void next() {
        turn.toggleActivePlayer();
    }

    public boolean isConnect4() {
        return turn.isConecta4();
    }

    public boolean isTie() {
        return turn.isTie();
    }

    public Color getActivePlayer() {
        return turn.getColorActivePlayer();
    }

    public void reset() {
        board.reset();
        turn.reset();
    }
}
