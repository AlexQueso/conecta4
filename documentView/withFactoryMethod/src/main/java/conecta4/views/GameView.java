package conecta4.views;

import conecta4.models.Game;

public abstract class GameView extends WithGameView {

    public GameView(Game game) {
        super(game);
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();
}
