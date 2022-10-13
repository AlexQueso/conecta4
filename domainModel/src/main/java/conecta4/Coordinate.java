package conecta4;

import utils.Console;

import java.util.Objects;

public class Coordinate {
    public static final Coordinate ORIGIN_COORDINATE = new Coordinate(0, 0);
    private int row;

    private int column;

    Coordinate() {
    }

    Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static int read(String message) {
        assert message != null;

        int column;
        boolean error;

        do {
            Console console = Console.getInstance();
            console.writeln(message);
            column = console.readInt(Message.COLUMN.toString()) - 1;

            error = !isValidColumn(column);
            if (error) {
                Error.WRONG_COLUMN.writeln();
            }
        } while (error);

        return column;
    }

    public static boolean isValidColumn(int column) {
        return column < Board.COLUMNS && column >= 0;
    }

    public boolean isValidCoordinate() {
        return (this.column < Board.COLUMNS && this.column >= 0) && (this.row < Board.ROWS && this.row >= 0);
    }

    public Coordinate changeCoordinateWithDirection(Coordinate coordinate){
        return new Coordinate(this.row + coordinate.getRow(), this.column + coordinate.getColumn());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
