package conecta4.controllers;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.types.Color;

public class Logic {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic(Game game) {
        this.game = game;
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public void reset() {
        this.resumeController.reset();
    }

    public void putToken(int column) {
        this.playController.putToken(column);
    }

    public boolean isColumnFull(int column) {
        return this.playController.isColumnFull(column);
    }

    public void next() {
        this.playController.next();
    }

    public boolean isGameOver() {
        return this.playController.isGameOver();
    }

    public boolean isTie() {
        return this.playController.isTie();
    }

    public Color getActivePlayer() {
        return this.playController.getActivePlayer();
    }
}
