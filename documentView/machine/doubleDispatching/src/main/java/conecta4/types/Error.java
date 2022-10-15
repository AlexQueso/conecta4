package conecta4.types;

import utils.views.Console;

public enum Error {
    FULL,
    WRONG_COLUMN,
    WRONG_NUMBER,
    NULL;

    Error() {
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}