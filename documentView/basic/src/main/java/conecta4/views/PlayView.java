package conecta4.views;

import conecta4.models.Game;

public class PlayView extends WithGameView {
    public PlayView(Game game) {
        super(game);
    }

    public void interact() {
        do {
            new PlayerView(game).interact();
            game.next();
            new BoardView(game).print();
        } while (!game.isGameOver());
        if (game.isTie()) {
            Message.TIE.writeln();
        } else {
            Message.PLAYER_WIN.writeln(this.game.getActivePlayer().name());
        }
    }
}
