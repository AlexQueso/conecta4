package conecta4.views;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import utils.views.Console;

public class BoardView {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    public void print(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < COLUMNS; j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
