package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Message;

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
