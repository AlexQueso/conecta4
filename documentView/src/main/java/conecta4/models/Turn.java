package conecta4.models;

import conecta4.types.Color;

public class Turn {
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;
    private int plays = 0;

    public Turn(Board board) {
        assert board != null;
        this.board = board;
        players = new Player[Turn.NUMBER_PLAYERS];
        reset();
    }

    public void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            players[i] = new Player(Color.get(i), board);
        }
        activePlayer = 0;
        plays = 0;
    }

    public void toggleActivePlayer() {
        if (!isConecta4()) {
            activePlayer = (activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public boolean isConecta4() {
        return players[activePlayer].isConecta4();
    }

    public Color getColorActivePlayer() {
        return players[activePlayer].getColor();
    }

    public boolean isTie() {
        return plays == 42;
    }

    public void addTokenToGoals(Coordinate newTokenCoordinate) {
        players[activePlayer].addTokenToGoals(newTokenCoordinate);
    }
}
