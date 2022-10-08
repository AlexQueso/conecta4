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
            new BoardView().print(game); // todo: por que a veces se contruye la clase sin Game y otras con???
        } while (!game.isConnect4() && !game.isTie());
        if (game.isTie()) {
            Message.TIE.writeln();
        } else {
            Message.PLAYER_WIN.writeln(this.game.getActivePlayer().name());
        }
    }
}
