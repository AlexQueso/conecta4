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
            error = getPutTokenError(column);
        } while (!error.isNull());
        board.putToken(column, color);
    }

    private int getColumn() {
        return Coordinate.read(Message.ENTER_COLUMN_TO_PUT.toString());
    }

    private Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (board.isColumnFull(column)) {
            error = Error.FULL;
        }
        error.writeln();
        return error;
    }

    public void writeWinner() {
        Message.PLAYER_WIN.writeln(color.name());
    }

    public boolean isConnect4() {
        return this.board.isConnect4(this.color);
    }

    public Color getColor(){
        return color;
    }
}
