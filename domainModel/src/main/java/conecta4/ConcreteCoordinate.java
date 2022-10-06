package conecta4;

import java.util.Objects;

public class ConcreteCoordinate{
    static final String COLUMN = "Column: ";
    protected int row;
    protected int column;

    ConcreteCoordinate() {}

    ConcreteCoordinate(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public boolean isNull() {
        return false;
    }

    public Direction getDirection(ConcreteCoordinate coordinate) {
        if (this.equals(coordinate)){
            return Direction.NULL;
        }
        if (this.inHorizontal(coordinate)) {
            return Direction.HORIZONTAL;
        }
        if (this.inVertical(coordinate)) {
            return Direction.VERTICAL;
        }
        if (this.inAscendingDiagonal(coordinate) && coordinate.inAscendingDiagonal(coordinate)) {
            return Direction.ASCENDING_DIAGONAL;
        }
        return Direction.NULL;
    }

    public boolean inHorizontal(ConcreteCoordinate coordinate) {
        if (coordinate.isNull()){
            return false;
        }
        return this.row == coordinate.row;
    }

    public boolean inVertical(ConcreteCoordinate coordinate) {
        if (coordinate.isNull()){
            return false;
        }
        return this.column == coordinate.column;
    }

    //TODO: Calculo diagonal principal
    public boolean inAscendingDiagonal(ConcreteCoordinate coordinate) {
        return this.row - this.column == 0;
    }

    protected void read(String title) {
        Console console = Console.getInstance();
        console.writeln(title);
        this.column = console.readInt(ConcreteCoordinate.COLUMN) - 1;
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
        if (!(o instanceof ConcreteCoordinate)) return false;
        ConcreteCoordinate that = (ConcreteCoordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
