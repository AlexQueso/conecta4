package conecta4.views;

import conecta4.controllers.PlayController;

public abstract class Command {

    PlayController playController;

    String title;

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
