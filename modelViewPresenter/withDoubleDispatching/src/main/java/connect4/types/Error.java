package connect4.types;

public enum Error {
    FULL,
    WRONG_COLUMN,
    NULL;

    private String message;

    Error() {
    }

    public boolean isNull() {
        return this == Error.NULL;
    }
}