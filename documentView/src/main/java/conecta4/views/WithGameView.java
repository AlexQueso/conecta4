package conecta4.views;

import conecta4.models.Game;

public abstract class WithGameView {

    protected Game game;

    WithGameView(Game game) {
        this.game = game;
    }
}
