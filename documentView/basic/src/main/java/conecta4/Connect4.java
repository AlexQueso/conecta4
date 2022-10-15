package conecta4;

import conecta4.models.Game;
import conecta4.views.GameView;

class Connect4 {

    private Game game;
    private GameView gameView;

    Connect4() {
        this.game = new Game();
        this.gameView = new GameView(this.game);
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