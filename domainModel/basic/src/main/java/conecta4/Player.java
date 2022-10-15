package conecta4;

public class Player {
    private final Color color;
    private final Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    public void putToken() {
        int column;
        Error error;
        do {
            column = getColumn();
            error = getFullColumnError(column);
        } while (!error.isNull());
        board.putToken(column, color);
    }

    private int getColumn() {
        return Coordinate.read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getFullColumnError(int column) {
        Error error = Error.NULL;
        if (board.isColumnFull(column)) {
            error = Error.FULL;
        }
        error.writeln();
        return error;
    }

    public Color getColor() {
        return color;
    }
}
