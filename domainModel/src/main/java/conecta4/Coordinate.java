package conecta4;

import utils.Console;

import java.util.Objects;

public class Coordinate {
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
            this.column = console.readInt(Message.COLUMN.toString()) - 1;
            this.row = 0;

            error = !isValid();
            if (error) {
                Error.WRONG_COLUMN.writeln();
            }
        } while (error);
    }

    private boolean isValid() {
        return column < Board.COLUMNS && column >= 0;
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
