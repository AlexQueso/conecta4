package conecta4.models;

import conecta4.types.Color;
import conecta4.types.StateValue;

public class Session {

    private Game game;
    private State state;
    private Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
        this.registry.reset();
    }

    public void nextState() {
        this.state.next();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public void next() {
        this.game.next();
        this.registry.register();
    }

    public boolean isGameOver() {
        return this.game.isGameOver();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public boolean isTie() {
        return this.game.isTie();
    }

    public Color getActivePlayer() {
        return this.game.getActivePlayer();
    }

    public void putToken(int column) {
        this.game.putToken(column);
    }

    public boolean isColumnFull(int column) {
        return this.game.isColumnFull(column);
    }

    public void redo() {
        registry.redo();
    }

    public boolean isRedoable() {
        return registry.isRedoable();
    }

    public void undo() {
        registry.undo();
    }

    public boolean isUndoable() {
        return registry.isUndoable();
    }
}
