package conecta4.views;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.types.Error;

public class PlayerView {

    private Game game;

    public PlayerView(Game game) {
        this.game = game;
    }

    public void interact() {
        putToken();
    }

    private void putToken() {
        Coordinate coordinateWithoutRow;
        Error error;
        do {
            coordinateWithoutRow = getColumn();
            error = getPutTokenError(coordinateWithoutRow);
        } while (!error.isNull());
        Coordinate newTokenCoordinate = game.putToken(coordinateWithoutRow);
        game.addTokenToPlayerGoals(newTokenCoordinate);
    }

    private Coordinate getColumn() {
        return new CoordinateView().read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private conecta4.types.Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        conecta4.types.Error error = conecta4.types.Error.NULL;
        if (game.isColumnFull(coordinate)) {
            error = conecta4.types.Error.FULL;
        }
        new ErrorView().writeln(error);
        return error;
    }
}
