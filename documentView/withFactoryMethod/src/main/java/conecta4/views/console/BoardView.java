package conecta4.views.console;

import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.views.Message;
import conecta4.views.WithGameView;
import utils.views.Console;

public class BoardView extends WithGameView {

    public BoardView(Game game) {
        super(game);
    }

    public void print() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = game.getBoardRows() - 1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < game.getBoardColumns(); j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
