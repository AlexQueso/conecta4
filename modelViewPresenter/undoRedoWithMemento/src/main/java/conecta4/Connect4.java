package conecta4;

import conecta4.controllers.*;
import conecta4.models.Game;
import conecta4.views.GameView;

class Connect4 {

    private GameView gameView;
    private Logic logic;

    Connect4() {
        this.logic = new Logic();
        this.gameView = new GameView(logic);
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