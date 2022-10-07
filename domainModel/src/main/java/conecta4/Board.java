package conecta4;

import utils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private Map<Coordinate, Color> boardMap;

    Board() {
        this.boardMap = new HashMap<>();
    }

    Coordinate putToken(Coordinate coordinate, Color color) {
        assert !(coordinate == null);

        Coordinate newTokenCoordinate = new Coordinate(calculateEmptyRow(coordinate), coordinate.getColumn());
        this.boardMap.put(newTokenCoordinate, color);

        return newTokenCoordinate;
    }

    private int calculateEmptyRow(Coordinate playerCoordinate) {
        int maxRow = 0;

        for (Coordinate boardCoordinate : boardMap.keySet()) {
            if (boardCoordinate.getColumn() == playerCoordinate.getColumn()) {
                maxRow += 1;
            }
        }

        return maxRow;
    }

    public void reset() {
        this.boardMap = new HashMap<>();
    }

    private Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        return this.boardMap.getOrDefault(coordinate, Color.NULL);
    }

    public boolean isColumnFull(Coordinate coordinate) {
        return this.boardMap.containsKey(new Coordinate(ROWS - 1, coordinate.getColumn()));
    }

    public void print() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < COLUMNS; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

    public List<Goal> surroundingGoals(Coordinate coordinate, Color color) {
        ArrayList<Goal> surroundingGoals = new ArrayList<>();
        List<Goal> ascendingDiagonalCoordinates = surroundingAscendingDiagonal(coordinate, color);
        if (!ascendingDiagonalCoordinates.isEmpty()) {
            surroundingGoals.addAll(ascendingDiagonalCoordinates);
        }
        List<Goal> descendingDiagonalCoordinates = surroundingDescendingDiagonal(coordinate, color);
        if (!descendingDiagonalCoordinates.isEmpty()) {
            surroundingGoals.addAll(descendingDiagonalCoordinates);
        }
        List<Goal> horizontalCoordinates = surroundingHorizontal(coordinate, color);
        if (!horizontalCoordinates.isEmpty()) {
            surroundingGoals.addAll(horizontalCoordinates);
        }
        List<Goal> verticalCoordinates = surroundingVertical(coordinate, color);
        if (!verticalCoordinates.isEmpty()) {
            surroundingGoals.addAll(verticalCoordinates);
        }
        return surroundingGoals;
    }

    private List<Goal> surroundingAscendingDiagonal(Coordinate coordinate, Color color) {
        Coordinate leftDownCoordinate = new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() - 1);
        Coordinate rightUpCoordinate = new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() + 1);
        return surroundingDirectionCoordinates(leftDownCoordinate, rightUpCoordinate, color, Direction.ASCENDING_DIAGONAL);
    }

    private List<Goal> surroundingDescendingDiagonal(Coordinate coordinate, Color color) {
        Coordinate leftUpCoordinate = new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() + 1);
        Coordinate rightDownCoordinate = new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() - 1);
        return surroundingDirectionCoordinates(leftUpCoordinate, rightDownCoordinate, color, Direction.DESCENDING_DIAGONAL);
    }

    private List<Goal> surroundingVertical(Coordinate coordinate, Color color) {
        Coordinate downCoordinate = new Coordinate(coordinate.getRow() - 1, coordinate.getColumn());
        Coordinate upCoordinate = new Coordinate(coordinate.getRow() + 1, coordinate.getColumn());
        return surroundingDirectionCoordinates(downCoordinate, upCoordinate, color, Direction.VERTICAL);
    }

    private List<Goal> surroundingHorizontal(Coordinate coordinate, Color color) {
        Coordinate leftCoordinate = new Coordinate(coordinate.getRow(), coordinate.getColumn() - 1);
        Coordinate rightCoordinate = new Coordinate(coordinate.getRow(), coordinate.getColumn() + 1);
        return surroundingDirectionCoordinates(leftCoordinate, rightCoordinate, color, Direction.HORIZONTAL);
    }

    private List<Goal> surroundingDirectionCoordinates(Coordinate c1, Coordinate c2, Color color, Direction direction) {
        List<Goal> goals = new ArrayList<>();
        if (checkExistingToken(c1, color)) {
            if (checkExistingToken(c2, color)) {
                goals.add(new Goal(direction, new ArrayList<>(List.of(c1, c2))));
            } else {
                goals.add(new Goal(direction, new ArrayList<>(List.of(c1))));
            }
        }
        if (checkExistingToken(c2, color)) {
            goals.add(new Goal(direction, new ArrayList<>(List.of(c2))));
        }
        return goals;
    }

    private boolean checkExistingToken(Coordinate coordinate, Color color) {
        return getColor(coordinate) == color;
    }
}
