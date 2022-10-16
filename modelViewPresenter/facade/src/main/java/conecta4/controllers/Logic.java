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

    public StartController getStartController() {
        return startController;
    }

    public PlayController getPlayController() {
        return playController;
    }

    public ResumeController getResumeController() {
        return resumeController;
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
