package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Message;

public class PlayView {
    public void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } while (!playController.isGameOver());
        if (playController.isTie()) {
            new MessageView().writeln(Message.TIE);
        } else {
            new MessageView().writeln(Message.PLAYER_WIN, playController.getActivePlayer().name());
        }
        playController.nextState();
    }
}
