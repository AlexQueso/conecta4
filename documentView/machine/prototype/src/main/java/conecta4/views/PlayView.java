package conecta4.views;

import conecta4.models.Game;

public class PlayView extends WithGameView  {

    private PlayerViewPrototype playerViewPrototype;
    public PlayView(Game game) {
        super(game);
        this.playerViewPrototype = new PlayerViewPrototype(game);
    }

    public void interact() {
        do {
            PlayerView playerView = this.playerViewPrototype.createView(this.game.getType());
            playerView.interact();
            this.game.next();
            new BoardView(game).print();
        } while (!game.isGameOver());
        if (game.isTie()) {
            Message.TIE.writeln();
        } else {
            Message.PLAYER_WIN.writeln(this.game.getColorInactivePlayer().name());
        }
    }
}
