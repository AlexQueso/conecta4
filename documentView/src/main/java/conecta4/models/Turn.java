package conecta4.models;

import conecta4.types.Color;

public class Turn {
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private final Color[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;

        this.board = board;
        players = new Color[Turn.NUMBER_PLAYERS];
        prepareTurn();
    }

    public void prepareTurn() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            players[i] = Color.get(i);
        }
        activePlayer = 0;
        board.reset();
    }

    public void toggleActivePlayer() {
        activePlayer = (activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
    public Color getColorActivePlayer() {
        return players[activePlayer];
    }

    public boolean isGameOver() {
        return isConnect4() || isTie();
    }

    public boolean isConnect4() {
        return board.isConnect4(players[activePlayer]);
    }

    public boolean isTie() {
        return board.isTie();
    }
}
