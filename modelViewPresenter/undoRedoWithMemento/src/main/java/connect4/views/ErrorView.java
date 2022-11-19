package connect4.views;

import connect4.types.Error;
import utils.views.Console;

public class ErrorView {

    static final String[] MESSAGES = {
            "The column is full",
            "The column is wrong",
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
