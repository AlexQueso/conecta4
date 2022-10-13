package conecta4;

public class Turn {
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;

    Turn(Board board) {
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
        board.reset();
    }

    public void play() {
        players[activePlayer].putToken();
        if (!isConnect4()) {
            toggleActivePlayer();
        }
    }

    private void toggleActivePlayer() {
        activePlayer = (activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }

    public boolean isConnect4() {
        return players[activePlayer].isConnect4();
    }

    public void writeResult() {
        if (isTie()) {
            Message.TIE.writeln();
        } else {
            players[activePlayer].writeWinner();
        }
    }

    public boolean isTie() {
        return board.isTie();
    }

    public boolean isGameOver(){
        return isConnect4() || isTie();
    }
}
