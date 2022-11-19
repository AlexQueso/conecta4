package connect4.controllers;

import connect4.models.Session;

public class RedoController extends Controller {

    RedoController(Session session) {
        super(session);
    }

    public void redo() {
        this.session.redo();
    }

    public boolean isRedoable() {
        return session.isRedoable();
    }
}
