package conecta4.views.console;

import conecta4.models.Game;
import conecta4.types.Error;
import conecta4.views.ErrorView;
import conecta4.views.Message;
import conecta4.views.WithGameView;
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
                Console.getInstance().writeln(ErrorView.MESSAGES[Error.WRONG_COLUMN.ordinal()]);
            }
        } while (error);
        return column;
    }

    private boolean isValidColumn(int column) {
        return column < game.getBoardColumns() && column >= 0;
    }
}
