package conecta4;

import utils.Console;

enum Error {
    FULL("The column is full"),

    WRONG_COLUMN("The column is wrong"),

    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    void writeln() {
        if (!this.isNull()) {
            Console.getInstance().writeln(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}