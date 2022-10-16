package conecta4.controllers;

import conecta4.models.Game;
import conecta4.types.Color;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
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

    public void putToken(int column) {
        this.game.putToken(column);
    }

    public boolean isColumnFull(int column) {
        return game.isColumnFull(column);
    }
}
