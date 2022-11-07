package connect4.views.console;

import connect4.types.Color;
import utils.views.Console;

public class ColorView {

    public void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        Console.getInstance().write(string);
    }
}
