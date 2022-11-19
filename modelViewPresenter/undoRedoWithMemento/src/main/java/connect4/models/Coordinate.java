package connect4.models;

import java.io.Serializable;
import java.util.Objects;

public class Coordinate implements Serializable {
    private int row;
    private int column;
    public static final Coordinate ORIGIN_COORDINATE = new Coordinate(0, 0);

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Coordinate changeCoordinateWithDirection(Coordinate coordinate) {
        return new Coordinate(this.row + coordinate.getRow(), this.column + coordinate.getColumn());
    }

    public boolean isValidCoordinate(int rows, int columns) {
        return (this.column < columns && this.column >= 0) && (this.row < rows && this.row >= 0);
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
