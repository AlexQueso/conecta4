package connect4.controllers;

import connect4.models.Coordinate;
import connect4.models.Session;
import connect4.types.Color;

public abstract class Controller {

    Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public void nextState() {
        this.session.nextState();
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }
}
