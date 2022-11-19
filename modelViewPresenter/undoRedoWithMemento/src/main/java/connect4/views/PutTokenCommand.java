package connect4.views;

import connect4.controllers.PlayController;
import connect4.types.Message;
import utils.views.Command;

public class PutTokenCommand extends Command {
    public PutTokenCommand(PlayController playController) {
        super(playController, Message.PUT_TOKEN_COMMAND.toString());
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void execute() {
        new PlayerView(playController).interact();
        this.playController.next();
        this.printBoard();
    }
}
