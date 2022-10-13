package conecta4;

public class Line {
    public static final int LENGTH = 4;
    private Coordinate origin;
    private Coordinate[] coordinates;
    private Direction oppositeDirection;

    public Line(Coordinate coordinate) {
        this.coordinates = new Coordinate[LENGTH];
        this.origin = coordinate;
    }

    public void setCoordinates(Direction direction) {
        this.coordinates[0] = this.origin;
        for (int i = 1; i < Line.LENGTH; i++) {
            this.coordinates[i] = this.coordinates[i-1].changeCoordinateWithDirection(direction.getCoordinate());
        }

        this.oppositeDirection = direction.getOpposite();
    }

    public void oppositeCoordinates() {
        for (int i = 0; i < Line.LENGTH; i++) {
            this.coordinates[i] = this.coordinates[i].changeCoordinateWithDirection(this.oppositeDirection.getCoordinate());
        }
    }

    public Coordinate[] getCoordinates() {
        return this.coordinates;
    }
}
