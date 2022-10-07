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

    protected void read(String message) {
        Console console = Console.getInstance();
        console.writeln(message);
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
