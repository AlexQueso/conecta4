package conecta4;

import conecta4.controllers.Logic;
import conecta4.controllers.PlayController;
import conecta4.controllers.ResumeController;
import conecta4.controllers.StartController;
import conecta4.models.Game;
import conecta4.views.GameView;

class Connect4 {


    private GameView gameView;
    private Logic logic;

    Connect4() {
        this.logic = new Logic(new Game());
        this.gameView = new GameView(logic);
    }

    private void play() {
        do {
            gameView.start();
            gameView.play();
        } while (gameView.resume());
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}