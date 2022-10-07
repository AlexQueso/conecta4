package conecta4;

import utils.YesNoDialog;

class Conecta4 {

    private Board board;
    private Turn turn;

    Conecta4() {
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
        } while (!turn.isConecta4() && !turn.isTie());
        if (turn.isTie()){
            Message.TIE.writeln();
        } else {
            turn.writeWinner();
        }
    }

    private boolean isReplayedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new Conecta4().play();
    }

}