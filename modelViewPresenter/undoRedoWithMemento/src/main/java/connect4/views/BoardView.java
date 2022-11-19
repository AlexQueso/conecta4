package connect4.views;

import connect4.controllers.Controller;
import connect4.models.Board;
import connect4.models.Coordinate;
import connect4.types.Message;
import utils.views.Console;

public class BoardView {

    public void print(Controller controller) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Board.ROWS - 1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Board.COLUMNS; j++) {
                new ColorView().write(controller.getColor(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
