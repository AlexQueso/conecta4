package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Message;

public class PlayView {

    private PlayController playController;

    public PlayView(PlayController playController) {
        this.playController = playController;
    }

    public void interact() {
        do {
            new PlayerView(this.playController).interact();
            this.playController.next();
            new BoardView().print(this.playController);
        } while (!this.playController.isGameOver());
        if (this.playController.isTie()) {
            new MessageView().writeln(Message.TIE);
        } else {
            new MessageView().writeln(Message.PLAYER_WIN, this.playController.getActivePlayer().name());
        }
    }
}
