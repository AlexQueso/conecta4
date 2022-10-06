package conecta4;

import java.util.Objects;

public class Coordinate{
    public static final int DIMENSION = 4;

    //TODO: Revisar si esta clase pinta aqui o no
    private ConcreteCoordinate concreteCoordinate;

    Coordinate() {
        this.concreteCoordinate = null;
    }

    Coordinate(int row, int column) {
        this.concreteCoordinate = new ConcreteCoordinate(row, column);
    }

    protected String getErrorMessage() {
        return Error.WRONG_COORDINATES.toString();
    }

    public void read(String message) {
        assert message != null;

        this.concreteCoordinate = new ConcreteCoordinate();

        boolean error;

        do {
            this.concreteCoordinate.read(message);
            error = !this.isValid();
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
    }

    private boolean isValid() {
        assert !this.concreteCoordinate.isNull();

        return this.concreteCoordinate.getRow() < Board.ROWS
                && this.concreteCoordinate.getRow() < Board.COLUMNS;
    }

    public int getRow(){
        return this.concreteCoordinate.getRow();
    }

    public int getColumn(){
        return this.concreteCoordinate.getColumn();
    }

    //TODO: Revisar - Uso de getter
    public Direction getDirection(Coordinate coordinate) {
        if (this.equals(coordinate) || this.isNull() || coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.inDescendingDiagonal() && coordinate.inDescendingDiagonal()) {
            return Direction.DESCENDING_DIAGONAL;
        }
        return this.concreteCoordinate.getDirection(coordinate.getConcreteCoordinate());
    }

    public boolean isNull() {
        return this.concreteCoordinate.isNull();
    }

    //TODO: Calculo de la diagonal inversa
    public boolean inDescendingDiagonal() {
        return false;
        //return this.concreteCoordinate.getRow() + this.concreteCoordinate.getColumn() == this.getDimension() - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return concreteCoordinate.equals(that.concreteCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concreteCoordinate);
    }

    public ConcreteCoordinate getConcreteCoordinate() {
        return concreteCoordinate;
    }
}
