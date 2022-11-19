package connect4.views;

import connect4.controllers.PlayController;
import connect4.types.Message;
import utils.views.Command;

public class UndoCommand extends Command {
    public UndoCommand(PlayController playController) {
        super(playController, Message.UNDO_COMMAND.toString());
    }

    @Override
    public boolean isActive() {
        return this.playController.isUndoable();
    }

    @Override
    public void execute() {
        this.playController.undo();
        this.printBoard();
    }
}
