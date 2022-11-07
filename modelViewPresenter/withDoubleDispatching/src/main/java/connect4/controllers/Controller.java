package connect4.controllers;

import connect4.models.Coordinate;
import connect4.models.Game;
import connect4.models.State;
import connect4.types.Color;

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

    public abstract void accept(ControllersVisitor controllersVisitor);
}
