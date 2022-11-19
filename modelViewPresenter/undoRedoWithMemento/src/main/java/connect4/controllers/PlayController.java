package connect4.controllers;

import connect4.models.Session;
import connect4.types.Color;

public class PlayController extends Controller implements AcceptorController {

    private PutTokenController putTokenController;
    private RedoController redoController;
    private UndoController undoController;

    public PlayController(Session session) {
        super(session);
        this.putTokenController = new PutTokenController(this.session);
        this.redoController = new RedoController(this.session);
        this.undoController = new UndoController(this.session);
    }

    public void next() {
        this.putTokenController.next();
    }

    public boolean isGameOver() {
        return this.putTokenController.isGameOver();
    }

    public boolean isTie() {
        return this.putTokenController.isTie();
    }

    public Color getActivePlayer() {
        return this.putTokenController.getActivePlayer();
    }

    public void putToken(int column) {
        this.putTokenController.putToken(column);
    }

    public boolean isColumnFull(int column) {
        return putTokenController.isColumnFull(column);
    }

    public boolean isRedoable() {
        return this.redoController.isRedoable();
    }

    public boolean isUndoable() {
        return this.undoController.isUndoable();
    }

    public void undo() {
        this.undoController.undo();
    }

    public void redo() {
        this.redoController.redo();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
