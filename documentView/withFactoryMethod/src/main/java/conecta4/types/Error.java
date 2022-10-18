package conecta4.types;

import utils.views.Console;

public enum Error {
    FULL,
    WRONG_COLUMN,
    NOT_NUMERIC_COLUMN,
    NULL;

    private String message;

    Error() {
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}