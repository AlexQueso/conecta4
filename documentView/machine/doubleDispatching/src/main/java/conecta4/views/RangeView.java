package conecta4.views;

import conecta4.types.Error;
import org.apache.commons.lang.math.IntRange;
import utils.views.Console;

public class RangeView {

    private IntRange intRange;

    public RangeView(IntRange intRange){
        this.intRange = intRange;
    }

    public int read(String message) {
        assert intRange != null;

        int number;
        boolean error;
        do {
            Console console = Console.getInstance();
            number = console.readInt(message);

            error = !this.intRange.containsInteger(number);
            if (error) {
                new ErrorView().writeln(Error.WRONG_NUMBER);
            }
        } while (error);
        return number;
    }
}
