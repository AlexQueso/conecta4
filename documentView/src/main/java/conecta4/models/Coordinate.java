package conecta4.models;

import java.util.Objects;

public class Coordinate {
    private int row;

    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate(int column) {
        this.column = column;
    }

    public boolean isValid() {
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
