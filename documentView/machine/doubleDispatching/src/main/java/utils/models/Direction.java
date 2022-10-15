package utils.models;

public class Direction {
    private Coordinate coordinate;

    public static Direction UP = new Direction(1, 0);
    public static Direction UP_RIGHT = new Direction(1, 1);
    public static Direction RIGHT = new Direction(0, 1);
    public static Direction DOWN_RIGHT = new Direction(-1, 1);
    public static Direction DOWN = new Direction(-1, 0);
    public static Direction DOWN_LEFT = new Direction(-1, -1);
    public static Direction LEFT = new Direction(0, -1);
    public static Direction UP_LEFT = new Direction(1, -1);

    private Direction(int row, int column) {
        this.coordinate = new Coordinate(row, column);
    }

    public Direction getOpposite() {
        for (Direction direction : Direction.getValues()) {
            if (direction.getCoordinate().changeCoordinateWithDirection(this.coordinate).equals(Coordinate.ORIGIN_COORDINATE)) {
                return direction;
            }
        }
        return null;
    }

    public static Direction[] getValues() {
        return new Direction[]{UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT, UP_LEFT};
    }

    public static Direction[] getDirectionsWithoutOpposites() {
        return new Direction[]{UP, UP_RIGHT, RIGHT, DOWN_RIGHT};
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }
}
