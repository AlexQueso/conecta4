package conecta4;

import conecta4.models.Game;
import conecta4.views.GameView;

public abstract class Connect4 {

    private Game game;
    private GameView gameView;

    Connect4() {
        this.game = new Game();
        this.gameView = this.createView(this.game);
    }

    protected abstract GameView createView(Game game);

    protected void play() {
        do {
            this.gameView.start();
            this.gameView.play();
        } while (this.gameView.resume());
    }
}