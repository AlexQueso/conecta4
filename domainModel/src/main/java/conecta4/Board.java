package conecta4;

import utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    public static final int MAX_TOKENS = 42;
    private Color[][] colors;
    private int tokensInBoard;
    private Coordinate lastToken;

    Board() {
        this.colors = new Color[ROWS][COLUMNS];
        this.reset();
    }

    public void reset() {
        this.tokensInBoard = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    Coordinate putToken(int column, Color color) {
        Coordinate coordinateToBoard = new Coordinate(calculateEmptyRow(column), column);
        this.colors[coordinateToBoard.getRow()][coordinateToBoard.getColumn()] = color;
        this.lastToken = coordinateToBoard;
        this.tokensInBoard++;

        return coordinateToBoard;
    }

    private int calculateEmptyRow(int column) {
        for(int i = 0; i<ROWS; i++){
            if(this.colors[i][column].isNull()){
                return i;
            }
        }

        return 0;
    }

    private Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public boolean isColumnFull(int column) {
        return !this.colors[ROWS-1][column].isNull();
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

    public boolean isWinner(Color color){
        assert color != null && this.lastToken != null;

        Line line = new Line(this.lastToken);

        // .splice(0, 3) -> En el codigo de setillo

        for (Direction direction : Direction.getValues()) {
            line.setCoordinates(direction);
            for (int i = 0; i < Line.LENGTH; i++) {
                if (this.isConnect4(line)) {
                    return true;
                }
                line.oppositeCoordinates();
            }
        }

        return false;
    }

    public boolean isConnect4(Line line){
        assert line != null;

        Coordinate[] coordinates = line.getCoordinates();
        for (int i = 0; i < Line.LENGTH; i++) {
            if (!coordinates[i].isValidCoordinate()) {
                return false;
            }
            if (i > 0 && this.getColor(coordinates[i - 1]) != this.getColor(coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isTie() {
        return this.tokensInBoard == MAX_TOKENS;
    }
}
