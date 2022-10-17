package conecta4.views;

import conecta4.models.Game;
import conecta4.models.Player;
import conecta4.types.Error;

public abstract class PlayerView extends WithGameView{

    PlayerView(Game game) {
        super(game);
    }

    public void interact() {
        putToken();
    }

    private void putToken() {
        int column;
        Error error;
        do {
            column = getColumn();
            error = getFullColumnError(column);
        } while (!error.isNull());
        game.putToken(column);
    }

    abstract int getColumn();

    private Error getFullColumnError(int column) {
        Error error = Error.NULL;
        if (game.isColumnFull(column)) {
            error = Error.FULL;
        }
        new ErrorView().writeln(error);
        return error;
    }
}
