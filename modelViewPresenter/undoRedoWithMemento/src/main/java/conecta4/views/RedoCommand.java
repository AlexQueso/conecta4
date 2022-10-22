package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Message;

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
