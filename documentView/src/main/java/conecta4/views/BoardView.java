package conecta4.views;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import utils.views.Console;

public class BoardView extends WithGameView {

    public BoardView(Game game) {
        super(game);
    }

    public void print() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = game.getBoardRows() - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < game.getBoardColumns(); j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
