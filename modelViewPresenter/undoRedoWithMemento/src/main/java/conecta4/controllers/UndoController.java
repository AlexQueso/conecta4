package conecta4.controllers;

import conecta4.models.Session;

public class UndoController extends Controller {
    UndoController(Session session) {
        super(session);
    }

    public void undo() {
        this.session.undo();
    }

    public boolean isUndoable() {
        return this.session.isUndoable();
    }
}
