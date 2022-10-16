package conecta4.views;

import conecta4.controllers.Logic;
import conecta4.types.Message;

public class PlayView extends WithLogicView {


    public PlayView(Logic logic) {
        super(logic);
    }

    public void interact() {
        do {
            new PlayerView(this.logic).interact();
            this.logic.next();
            new BoardView().print(this.logic);
        } while (!this.logic.isGameOver());
        if (this.logic.isTie()) {
            new MessageView().writeln(Message.TIE);
        } else {
            new MessageView().writeln(Message.PLAYER_WIN, this.logic.getActivePlayer().name());
        }
    }
}
