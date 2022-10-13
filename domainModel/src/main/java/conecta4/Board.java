package conecta4;

import utils.Console;

public class Board {
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private static final int MAX_TOKENS = 42;
    private Color[][] board;
    private int nTokensInBoard;
    private Coordinate lastToken;

    Board() {
        this.board = new Color[ROWS][COLUMNS];
        this.prepareBoard();
    }

    public void prepareBoard() {
        this.nTokensInBoard = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.board[i][j] = Color.NULL;
            }
        }
    }

    public void putToken(int column, Color color) {
        Coordinate coordinateToBoard = new Coordinate(calculateEmptyRow(column), column);
        this.board[coordinateToBoard.getRow()][coordinateToBoard.getColumn()] = color;
        this.lastToken = coordinateToBoard;
        this.nTokensInBoard++;
    }

    private int calculateEmptyRow(int column) {
        for (int i = 0; i < ROWS; i++) {
            if (this.board[i][column].isNull()) {
                return i;
            }
        }

        return 0;
    }

    private Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        return this.board[coordinate.getRow()][coordinate.getColumn()];
    }

    public boolean isColumnFull(int column) {
        return !this.board[ROWS - 1][column].isNull();
    }

    public void print() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < COLUMNS; j++) {
                getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

    public boolean isConnect4(Color color) {
        assert color != null && this.lastToken != null;

        Line line = new Line(this.lastToken);
        for (Direction direction : Direction.getDirectionsWithoutOpposites()) {
            line.setCoordinates(direction);
            for (int i = 0; i < Line.LENGTH; i++) {
                if (this.isWinnerLine(line)) {
                    return true;
                }
                line.oppositeCoordinates();
            }
        }

        return false;
    }

    private boolean isWinnerLine(Line line) {
        assert line != null;

        Coordinate[] coordinates = line.getCoordinates();
        for (int i = 0; i < Line.LENGTH; i++) {
            if (!coordinates[i].isValidCoordinate()) {
                return false;
            }
            if (i > 0 && this.getColor(coordinates[i - 1]) != this.getColor(coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isTie() {
        return this.nTokensInBoard == MAX_TOKENS;
    }
}
