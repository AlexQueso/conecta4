package conecta4.models;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<Memento> mementos;

    private Game game;

    private int currentMemento;

    public Registry(Game game) {
        this.game = game;
        this.reset();
    }

    public void reset() {
        this.mementos = new ArrayList<>();
        this.currentMemento = 0;
        this.mementos.add(new Memento(game));
    }

    public void register() {
        if (this.mementos.size() > currentMemento) {
            this.mementos = this.mementos.subList(0, currentMemento);
        }
        this.currentMemento++;
        this.mementos.add(new Memento(game));
    }

    public void redo() {
        assert isRedoable();

        this.currentMemento++;
        this.game.setMemento(this.mementos.get(currentMemento));
    }

    public boolean isRedoable() {
        return this.currentMemento < this.mementos.size();
    }

    public void undo() {
        assert isUndoable();

        this.currentMemento--;
        this.game.setMemento(this.mementos.get(currentMemento));
    }

    public boolean isUndoable() {
        return this.currentMemento > 0;
    }
}
