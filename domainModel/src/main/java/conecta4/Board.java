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
        boardMap = new HashMap<>();
    }

    Coordinate putToken(Coordinate coordinateWithoutRow, Color color) {
        assert !(coordinateWithoutRow == null);

        Coordinate coordinateToBoard = new Coordinate(calculateEmptyRow(coordinateWithoutRow), coordinateWithoutRow.getColumn());
        boardMap.put(coordinateToBoard, color);

        return coordinateToBoard;
    }

    private int calculateEmptyRow(Coordinate coordinateWithoutRow) {
        int occupiedRows = 0;

        for (Coordinate boardCoordinate : boardMap.keySet()) {
            if (boardCoordinate.getColumn() == coordinateWithoutRow.getColumn()) {
                occupiedRows++;
            }
        }

        return occupiedRows;
    }

    public void reset() {
        boardMap = new HashMap<>();
    }

    private Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        return boardMap.getOrDefault(coordinate, Color.NULL);
    }

    public boolean isColumnFull(Coordinate coordinate) {
        return boardMap.containsKey(new Coordinate(ROWS - 1, coordinate.getColumn()));
    }

    public void print() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < COLUMNS; j++) {
                getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

    public List<Goal> surroundingGoals(Coordinate coordinate, Color color) {
        ArrayList<Goal> surroundingGoals = new ArrayList<>();

        List<Goal> ascendingDiagonalCoordinates = surroundingAscendingDiagonal(coordinate, color);
        surroundingGoals.addAll(ascendingDiagonalCoordinates);
        List<Goal> descendingDiagonalCoordinates = surroundingDescendingDiagonal(coordinate, color);
        surroundingGoals.addAll(descendingDiagonalCoordinates);
        List<Goal> horizontalCoordinates = surroundingHorizontal(coordinate, color);
        surroundingGoals.addAll(horizontalCoordinates);
        List<Goal> verticalCoordinates = surroundingVertical(coordinate, color);
        surroundingGoals.addAll(verticalCoordinates);

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
