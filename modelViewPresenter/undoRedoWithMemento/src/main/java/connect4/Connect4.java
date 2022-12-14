package connect4;

import connect4.controllers.*;
import connect4.views.GameView;

class Connect4 {

    private GameView gameView;
    private Logic logic;

    Connect4() {
        this.logic = new Logic();
        this.gameView = new GameView();
    }

    protected void play() {
        AcceptorController acceptorController;
        do {
            acceptorController = logic.getController();
            if (acceptorController != null)
                acceptorController.accept(this.gameView);
        } while (acceptorController != null);
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}