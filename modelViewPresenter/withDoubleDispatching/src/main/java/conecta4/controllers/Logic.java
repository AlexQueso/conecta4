package conecta4.controllers;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.models.State;
import conecta4.models.StateValue;
import conecta4.types.Color;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Game game;
    private State state;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

    public Color getColor(Coordinate coordinate) {
        return game.getColor(coordinate);
    }

    public void reset() {
        this.game.reset();
    }

    public void putToken(int column) {
        this.game.putToken(column);
    }

    public boolean isColumnFull(int column) {
        return this.game.isColumnFull(column);
    }

    public void next() {
        this.game.next();
    }

    public boolean isGameOver() {
        return this.game.isGameOver();
    }

    public boolean isTie() {
        return this.game.isTie();
    }

    public Color getActivePlayer() {
        return this.game.getActivePlayer();
    }
}
