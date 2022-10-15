package conecta4.models;

import conecta4.types.Color;
import utils.models.Coordinate;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void setPlayers(int numberOfUserPlayers){
        turn.setPlayers(numberOfUserPlayers);
    }

    public Color getColor(Coordinate coordinate) {
        return board.getColor(coordinate);
    }

    public void nextPlayer() {
        turn.toggleActivePlayer();
    }

    public boolean isTie() {
        return turn.isTie();
    }

    public boolean isGameOver() {
        return turn.isGameOver();
    }

    public Player getActivePlayer() {
        return turn.getActivePlayer();
    }

    public Color getColorInactivePlayer() {
        return turn.getColorInactivePlayer();
    }

    public void reset() {
        board.reset();
        turn.reset();
    }
}
