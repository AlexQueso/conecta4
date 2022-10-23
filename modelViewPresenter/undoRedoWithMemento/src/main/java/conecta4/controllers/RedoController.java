package conecta4.controllers;

import conecta4.models.Session;

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
