package conecta4.views;

import conecta4.models.Game;

public class StartView extends WithGameView {
    public StartView(Game game) {
        super(game);
    }

    public void interact() {
        Message.TITLE.writeln();
        new BoardView(game).print();
    }
}
