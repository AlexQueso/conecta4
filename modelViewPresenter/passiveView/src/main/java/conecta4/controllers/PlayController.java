package conecta4.controllers;

import conecta4.models.Game;
import conecta4.types.Color;
import conecta4.types.Error;
import conecta4.views.Message;
import conecta4.views.ViewFactory;
import conecta4.views.console.ErrorView;
import conecta4.views.console.MessageView;

public class PlayController extends Controller {

    public PlayController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public void control() {
        do {
            this.putToken();
            this.game.next();
            this.writeBoard();
        } while (!this.game.isGameOver());
        if (this.game.isTie()) {
            this.viewFactory.createPlayerView().writeTie();
        } else {
            this.viewFactory.createPlayerView().writeWinner(this.game.getActivePlayer());
        }
    }

    private void putToken() {
        int column;
        Error error;
        do {
            column = getColumn(Message.ENTER_COLUMN_TO_PUT);
            error = isColumnFull(column);
        } while (!error.isNull());
        this.game.putToken(column);
    }

    private int getColumn(Message message) {
        assert message != null;

        return this.viewFactory.createCoordinateView().read(message.toString());
    }

    private Error isColumnFull(int column) {
        Error error = Error.NULL;
        if(game.isColumnFull(column)){
            error = Error.FULL;
        }
        this.viewFactory.createErrorView().writeln(error);
        return error;
    }
}
