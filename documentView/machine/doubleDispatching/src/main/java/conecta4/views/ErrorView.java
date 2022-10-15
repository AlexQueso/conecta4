package conecta4.views;

import conecta4.types.Error;
import utils.views.Console;

public class ErrorView {

    static final String[] MESSAGES = {
            "The column is full",
            "The column is wrong",
            "Invalid number"
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
