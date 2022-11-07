package connect4.views.console;

import connect4.controllers.PlayController;
import connect4.types.Message;

public class PlayView {
    public void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().print(playController);
        } while (!playController.isGameOver());
        if (playController.isTie()) {
            new MessageView().writeln(Message.TIE);
        } else {
            new MessageView().writeln(Message.PLAYER_WIN, playController.getActivePlayer().name());
        }

        playController.nextState();
    }
}
