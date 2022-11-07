package conecta4.controllers;

import conecta4.models.Game;

public abstract class Controller {

    protected Game game;

    public Controller(Game game) {
        this.game = game;
    }

}
