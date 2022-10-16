package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Error;
import conecta4.types.Message;

public class PlayerView {

    private PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }

    public void interact() {
        this.putToken();
    }

    private void putToken() {
        int column;
        Error error;
        do {
            column = getColumn();
            error = getFullColumnError(column);
        } while (!error.isNull());
        this.playController.putToken(column);
    }

    private int getColumn() {
        return new CoordinateView().read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getFullColumnError(int column) {
        Error error = Error.NULL;
        if (playController.isColumnFull(column)) {
            error = Error.FULL;
        }
        new ErrorView().writeln(error);
        return error;
    }
}
