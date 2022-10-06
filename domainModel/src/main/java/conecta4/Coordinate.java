package conecta4;

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

    // TODO: Review equals method
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!this.concreteCoordinate.equals(((Coordinate)obj).getConcreteCoordinate()))
            return false;
        return getClass() == obj.getClass();
    }

    public ConcreteCoordinate getConcreteCoordinate() {
        return concreteCoordinate;
    }
}
