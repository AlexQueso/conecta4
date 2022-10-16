package conecta4.views;

import conecta4.controllers.Logic;
import conecta4.types.Error;
import conecta4.types.Message;

public class PlayerView extends WithLogicView {

    public PlayerView(Logic logic) {
        super(logic);
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
        this.logic.putToken(column);
    }

    private int getColumn() {
        return new CoordinateView().read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getFullColumnError(int column) {
        Error error = Error.NULL;
        if (logic.isColumnFull(column)) {
            error = Error.FULL;
        }
        new ErrorView().writeln(error);
        return error;
    }
}
