package conecta4.views;

import conecta4.controllers.Logic;
import conecta4.models.Board;
import conecta4.models.Coordinate;
import conecta4.types.Message;
import utils.views.Console;

public class BoardView {

    public void print(Logic logic) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Board.ROWS - 1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Board.COLUMNS; j++) {
                new ColorView().write(logic.getColor(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
