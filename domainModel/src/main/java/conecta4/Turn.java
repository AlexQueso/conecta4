package conecta4;

public class Turn {
    private Board board;
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private int plays = 0;

    Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
        board.reset();
        plays = 0;
    }

    void play(){
        this.players[this.activePlayer].play();
        plays ++;
        if (!isConecta4()){
            this.activePlayer = (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
        }
    }

    public boolean isConecta4(){
        return this.players[this.activePlayer].isConecta4();
    }

    void writeWinner(){
        this.players[this.activePlayer].writeWinner();
    }

    public boolean isTie() {
        return plays == 42;
    }
}
