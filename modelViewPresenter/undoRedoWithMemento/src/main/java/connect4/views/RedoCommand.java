package connect4.views;

import connect4.controllers.PlayController;
import connect4.types.Message;
import utils.views.Command;

public class RedoCommand extends Command {
    public RedoCommand(PlayController playController) {
        super(playController, Message.REDO_COMMAND.toString());
    }

    @Override
    public boolean isActive() {
        return this.playController.isRedoable();
    }

    @Override
    public void execute() {
        this.playController.redo();
        this.printBoard();
    }
}
