package conecta4.views.console;

import conecta4.models.Board;
import conecta4.models.Coordinate;
import conecta4.views.Message;
import utils.views.Console;

public class BoardView extends conecta4.views.BoardView {

    @Override
    public void print() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Board.ROWS - 1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Board.COLUMNS; j++) {
                new ColorView().write(this.colors.get(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
