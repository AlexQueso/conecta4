package conecta4;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConcreteCoordinate other = (ConcreteCoordinate) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Coordinate (" + row + ", " + column + ")";
    }

}
