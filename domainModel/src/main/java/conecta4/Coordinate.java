package conecta4;

import java.util.Objects;

public class Coordinate{

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
}
