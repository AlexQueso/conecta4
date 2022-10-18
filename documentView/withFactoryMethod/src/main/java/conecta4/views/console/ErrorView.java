package conecta4.views.console;

import conecta4.types.Error;
import utils.views.Console;

public class ErrorView extends conecta4.views.ErrorView{
    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(conecta4.views.ErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
