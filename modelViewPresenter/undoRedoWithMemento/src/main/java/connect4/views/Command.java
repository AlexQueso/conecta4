package connect4.views;

import connect4.controllers.PlayController;

public abstract class Command extends utils.models.Command {

    protected PlayController playController;

    protected Command(PlayController playController, String title) {
        super(title);
        this.playController = playController;
    }

    protected void printBoard(){
        new BoardView().print(playController);
    }

}
