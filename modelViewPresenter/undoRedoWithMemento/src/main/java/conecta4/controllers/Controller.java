package conecta4.controllers;

import conecta4.models.Coordinate;
import conecta4.models.Session;
import conecta4.types.Color;

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
