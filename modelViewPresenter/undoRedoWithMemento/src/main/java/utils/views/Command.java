package utils.views;

import conecta4.controllers.PlayController;
import conecta4.views.BoardView;

public abstract class Command {

    protected PlayController playController;

    protected String title;

    public Command(PlayController playController, String title) {
        this.playController = playController;
        this.title = title;
    }

    public abstract boolean isActive();

    public abstract void execute();

    protected void printBoard(){
        new BoardView().print(playController);
    }

    public String getTitle() {
        return this.title;
    }
}