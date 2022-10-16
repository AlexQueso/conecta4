package conecta4;

import conecta4.controllers.PlayController;
import conecta4.controllers.ResumeController;
import conecta4.controllers.StartController;
import conecta4.models.Game;
import conecta4.views.GameView;

class Connect4 {

    private Game game;
    private GameView gameView;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    Connect4() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.gameView = new GameView(startController, playController, resumeController);
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