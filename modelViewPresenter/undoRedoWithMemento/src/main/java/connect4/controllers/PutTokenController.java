package connect4.controllers;

import connect4.models.Session;
import connect4.types.Color;

public class PutTokenController extends Controller {

    PutTokenController(Session session) {
        super(session);
    }

    public void next() {
        this.session.next();
    }

    public boolean isGameOver() {
        return this.session.isGameOver();
    }

    public boolean isTie() {
        return this.session.isTie();
    }

    public Color getActivePlayer() {
        return this.session.getActivePlayer();
    }

    public void putToken(int column) {
        this.session.putToken(column);
    }

    public boolean isColumnFull(int column) {
        return session.isColumnFull(column);
    }
}
