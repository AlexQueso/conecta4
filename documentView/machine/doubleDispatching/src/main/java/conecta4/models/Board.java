package conecta4.models;

import conecta4.types.Color;
import utils.models.Coordinate;
import utils.models.Direction;
import utils.models.Line;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private static final int MAX_TOKENS = 42;
    private Map<Coordinate, Color> boardMap;
    private Coordinate lastToken;

    public Board() {
        boardMap = new HashMap<>();
    }

    public void reset() {
        boardMap = new HashMap<>();
    }

    public void putToken(int column, Color color) {
        Coordinate coordinateToBoard = new Coordinate(calculateEmptyRow(column), column);
        this.boardMap.put(coordinateToBoard, color);
        this.lastToken = coordinateToBoard;
    }

    private int calculateEmptyRow(int column) {
        int emptyRow = 0;
        for (Coordinate coordinate : boardMap.keySet()) {
            if (coordinate.getColumn() == column) {
                emptyRow++;
            }
        }
        return emptyRow;
    }

    public Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        return boardMap.getOrDefault(coordinate, Color.NULL);
    }

    public boolean isColumnFull(int column) {
        return this.boardMap.containsKey(new Coordinate(ROWS - 1, column));
    }

    public boolean isConnect4(Color color) {
        assert color != null && this.lastToken != null;

        Line line = new Line(this.lastToken);
        for (Direction direction : Direction.getDirectionsWithoutOpposites()) {
            line.setCoordinates(direction);
            for (int i = 0; i < Line.LENGTH; i++) {
                if (this.isWinnerLine(line)) {
                    return true;
                }
                line.oppositeCoordinates();
            }
        }

        return false;
    }

    private boolean isWinnerLine(Line line) {
        assert line != null;

        Coordinate[] coordinates = line.getCoordinates();
        for (int i = 0; i < Line.LENGTH; i++) {
            if (!coordinates[i].isValidCoordinate(ROWS, COLUMNS)) {
                return false;
            }
            if (i > 0 && this.getColor(coordinates[i - 1]) != this.getColor(coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isTie() {
        return this.tokensInBoard() == MAX_TOKENS;
    }

    private int tokensInBoard() {
        return this.boardMap.size();
    }

}
