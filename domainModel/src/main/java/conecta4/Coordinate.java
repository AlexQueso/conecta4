package conecta4;

import utils.Console;

import java.util.Objects;

public class Coordinate {

    private static final String COLUMN = "Column: ";

    private int row;

    private int column;

    Coordinate() {
    }

    Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void read(String message) {
        assert message != null;

        boolean error;

        do {
            Console console = Console.getInstance();
            console.writeln(message);
            this.column = console.readInt(COLUMN) - 1;
            this.row = 0;

            error = !this.isValid();
            if (error) {
                Error.WRONG_COLUMN.writeln();
            }
        } while (error);
    }

    private boolean isValid() {
        return this.column < Board.COLUMNS && this.column >= 0;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    @Override
    public String toString() {
        return "Coordinate (" + row + ", " + column + ")";
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
