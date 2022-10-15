package conecta4.views;

import conecta4.models.Game;
import conecta4.models.MachinePlayer;
import conecta4.models.PlayerVisitor;
import conecta4.models.UserPlayer;

public class PlayView extends WithGameView implements PlayerVisitor {
    public PlayView(Game game) {
        super(game);
    }

    public void interact() {
        do {
            game.getActivePlayer().accept(this);
            game.nextPlayer();
            new BoardView(game).print();
        } while (!game.isGameOver());
        if (game.isTie()) {
            Message.TIE.writeln();
        } else {
            Message.PLAYER_WIN.writeln(this.game.getColorInactivePlayer().name());
        }
    }

    @Override
    public void visit(UserPlayer player) {
        new UserPlayerView(player).interact();
    }

    @Override
    public void visit(MachinePlayer player) {
        new MachinePlayerView(player).interact();
    }
}
