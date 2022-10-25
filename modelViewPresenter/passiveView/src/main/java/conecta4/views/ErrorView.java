package conecta4.views;

import conecta4.types.Error;
import utils.views.Console;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
            "The column is full",
            "The column is wrong",
    };

    public abstract void writeln(Error error);
}
