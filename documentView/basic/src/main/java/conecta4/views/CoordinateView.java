package conecta4.views;

import conecta4.models.Board;
import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.types.Error;
import utils.views.Console;

public class CoordinateView extends WithGameView {

    public CoordinateView(Game game) {
        super(game);
    }

    public int read(String message) {
        assert message != null;

        int column;
        boolean error;

        do {
            Console console = Console.getInstance();
            console.writeln(message);
            column = console.readInt(Message.COLUMN.toString()) - 1;

            error = !isValidColumn(column);
            if (error) {
                new ErrorView().writeln(Error.WRONG_COLUMN);
            }
        } while (error);
        return column;
    }

    private boolean isValidColumn(int column) {
        return column < game.getBoardColumns() && column >= 0;
    }
}
