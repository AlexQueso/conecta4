package connect4.views;

import connect4.models.Board;
import connect4.types.Error;
import connect4.types.Message;
import utils.views.Console;

public class CoordinateView {

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
        return column < Board.COLUMNS && column >= 0;
    }
}
