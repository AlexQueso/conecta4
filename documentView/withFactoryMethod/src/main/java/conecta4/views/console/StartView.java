package conecta4.views.console;

import conecta4.models.Game;
import conecta4.views.Message;
import conecta4.views.WithGameView;
import conecta4.views.console.BoardView;

public class StartView extends WithGameView {
    public StartView(Game game) {
        super(game);
    }

    public void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView(game).print();
    }
}
