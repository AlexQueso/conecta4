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
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.gameView);
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}