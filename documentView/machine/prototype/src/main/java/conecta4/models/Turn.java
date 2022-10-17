package conecta4.models;

import conecta4.types.Color;
import conecta4.types.PlayerType;

public class Turn {
    private Board board;
    public static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;

        this.board = board;
        players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    public void setPlayers(int numberUsers) {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            if (i < numberUsers) {
                this.players[i] = new UserPlayer(Color.get(i), this.board);
            } else {
                this.players[i] = new MachinePlayer(Color.get(i), this.board);
            }
        }
    }

    public void reset() {
        this.activePlayer = 0;
    }

    public void toggleActivePlayer() {
        activePlayer = (activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
    public Color getColorActivePlayer() {
        return players[activePlayer].getColor();
    }

    public Color getColorInactivePlayer() {
        return players[(activePlayer + 1) % Turn.NUMBER_PLAYERS].getColor();
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

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    public PlayerType getType() {
        return this.getActivePlayer().getType();
    }

    public int getRandomCoordinate() {
        return ((MachinePlayer) this.getActivePlayer()).getRandomColumn();
    }
}
