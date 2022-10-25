package conecta4.views.console;

import conecta4.models.Board;
import conecta4.types.Error;
import conecta4.views.ErrorView;
import conecta4.views.Message;
import utils.views.Console;

public class CoordinateView implements conecta4.views.CoordinateView {

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
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
        return column;
    }

    private boolean isValidColumn(int column) {
        return column < Board.COLUMNS && column >= 0;
    }

    private String getErrorMessage() {
        return ErrorView.MESSAGES[Error.WRONG_COLUMN.ordinal()];
    }
}
