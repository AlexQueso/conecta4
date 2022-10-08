package conecta4.views;

import conecta4.models.Coordinate;
import conecta4.types.Error;
import utils.views.Console;

public class CoordinateView {
    public Coordinate read(String message) {
        assert message != null;

        boolean error;
        Coordinate coordinate;

        do {
            Console console = Console.getInstance();
            console.writeln(message);
            coordinate = new Coordinate(console.readInt(Message.COLUMN.toString()) - 1);

            error = !coordinate.isValid();
            if (error) {
                new ErrorView().writeln(Error.WRONG_COLUMN);
            }
        } while (error);
        return coordinate;
    }
}
