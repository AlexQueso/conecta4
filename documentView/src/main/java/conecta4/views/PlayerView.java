package conecta4.views;

import conecta4.models.Game;
import conecta4.types.Error;

public class PlayerView extends WithGameView {

    public PlayerView(Game game) {
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

    private int getColumn() {
        return new CoordinateView(game).read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getFullColumnError(int column) {
        Error error = Error.NULL;
        if (game.isColumnFull(column)) {
            error = Error.FULL;
        }
        new ErrorView().writeln(error);
        return error;
    }
}
