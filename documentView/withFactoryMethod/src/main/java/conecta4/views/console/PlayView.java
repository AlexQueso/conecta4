package conecta4.views.console;

import conecta4.models.Game;
import conecta4.views.Message;
import conecta4.views.WithGameView;

public class PlayView extends WithGameView {
    public PlayView(Game game) {
        super(game);
    }

    public void interact() {
        do {
            new PlayerView(game).interact();
            this.game.next();
            new BoardView(game).print();
        } while (!game.isGameOver());
        if (game.isTie()) {
            new MessageView().writeln(Message.TIE);
        } else {
            new MessageView().writeln(Message.PLAYER_WIN, this.game.getActivePlayer().name());
        }
    }
}
