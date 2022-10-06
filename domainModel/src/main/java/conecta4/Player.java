package conecta4;

public class Player {
    private Color color;
    private Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    //TODO: Add tie condition
    void play() {
        this.putToken();
    }

    private void putToken() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.getColumn(Message.ENTER_COLUMN_TO_PUT);
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());
        this.board.putToken(coordinate, this.color);
        this.putTokens++;
    }

    Coordinate getColumn(Message message){
        assert message != null;

        Coordinate coordinate = new Coordinate();
        coordinate.read(message.toString());
        return coordinate;
    }

    private Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = Error.NULL;
        if (this.board.isFull(coordinate)) {
            error = Error.FULL;
        }
        error.writeln();
        return error;
    }

    void writeWinner() {
        Message.PLAYER_WIN.writeln(this.color.name());
    }

    Color getColor() {
        return this.color;
    }
}
