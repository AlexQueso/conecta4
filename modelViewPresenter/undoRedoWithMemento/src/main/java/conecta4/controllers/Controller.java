package conecta4.controllers;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.models.State;
import conecta4.types.Color;

public abstract class Controller {

    protected Game game;
    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }
}
