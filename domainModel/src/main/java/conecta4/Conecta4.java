package conecta4;

class Conecta4 {

    private Board board;
    private Turn turn;

    Conecta4(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play() {
        do {
            this.playGame();
        } while (this.isReplayedGame());
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isConecta4());
        this.turn.writeWinner();
    }

    private boolean isConecta4() {
        return this.board.isConecta4(this.turn.getActiveColor());
    }

    private boolean isReplayedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new Conecta4().play();
    }

}