package conecta4.models;

import conecta4.types.Color;
import conecta4.types.PlayerType;
import conecta4.views.CoordinateView;
import conecta4.views.Message;

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

    public Color getColorInactivePlayer() {
        return turn.getColorInactivePlayer();
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void setPlayers(int numberUsers) {
        this.turn.setPlayers(numberUsers);
    }

    public void putToken(int column) {
        board.putToken(column, turn.getColorActivePlayer());
    }

    public PlayerType getType() {
        return this.turn.getType();
    }

    public int getRandomColumn() {
        return this.turn.getRandomCoordinate();
    }
}
