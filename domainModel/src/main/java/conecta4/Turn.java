package conecta4;

public class Turn {
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;
    private int plays = 0;

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
        plays = 0;
    }

    public void play() {
        players[activePlayer].putToken();
        plays++;
        if (!isConecta4()) {
            toggleActivePlayer();
        }
    }

    private void toggleActivePlayer() {
        activePlayer = (activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }

    public boolean isConecta4() {
        return players[activePlayer].isConecta4();
    }

    public void writeResult() {
        if (isTie()) {
            Message.TIE.writeln();
        } else {
            players[activePlayer].writeWinner();
        }
    }

    public boolean isTie() {
        return plays == 42;
    }

    public boolean isGameOver(){
        return !isConecta4() && !isTie();
    }
}
