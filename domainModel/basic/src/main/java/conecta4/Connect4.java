package conecta4;

import utils.YesNoDialog;

class Connect4 {

    private Board board;
    private Turn turn;

    Connect4() {
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
        this.board.print();
        do {
            this.turn.play();
            this.board.print();
        } while (!turn.isGameOver());
        if (turn.isTie()) {
            Message.TIE.writeln();
        } else {
            turn.writeResult();
        }
    }

    private boolean isReplayedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.turn.prepareTurn();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new Connect4().play();
    }

}