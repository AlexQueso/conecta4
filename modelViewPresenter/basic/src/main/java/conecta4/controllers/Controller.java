package conecta4.controllers;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.types.Color;

public abstract class Controller {

    protected Game game;

    public Controller (Game game) {
        this.game = game;
    }

    public Color getColor(Coordinate coordinate){
        return this.game.getColor(coordinate);
    }
}
