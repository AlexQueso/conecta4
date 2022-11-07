package connect4.models;

import connect4.types.Color;

public class Turn {
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;

        this.board = board;
        players = new Player[Turn.NUMBER_PLAYERS];
        prepareTurn();
    }

    public void prepareTurn() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            players[i] = new Player(Color.get(i), board);
        }
        activePlayer = 0;
        board.reset();
    }

    public void toggleActivePlayer() {
        activePlayer = (activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
    public Color getColorActivePlayer() {
        return players[activePlayer].getColor();
    }

    public boolean isGameOver() {
        return isConnect4() || isTie();
    }

    public boolean isConnect4() {
        return board.isConnect4(players[activePlayer].getColor());
    }

    public boolean isTie() {
        return board.isTie();
    }
}
