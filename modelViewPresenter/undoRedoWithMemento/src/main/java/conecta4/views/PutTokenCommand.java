package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Message;

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
