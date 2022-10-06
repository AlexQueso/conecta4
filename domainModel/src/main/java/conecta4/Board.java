package conecta4;

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

    //TODO: Comparacion con objeto nulo
    void putToken(Coordinate coordinate, Color color) {
        assert !(coordinate == null);

        this.boardMap.put(new Coordinate(calculateEmptyRow(coordinate), coordinate.getColumn()), color);
    }

    // TODO: Revisar bucle, asignación de fila y return si acaba el for
    private int calculateEmptyRow(Coordinate playerCoordinate){
        int maxRow = 0;

        for(Coordinate boardCoordinate : boardMap.keySet()){
            if(boardCoordinate.getColumn() == playerCoordinate.getColumn()){
                maxRow += 1;
            }
        }

        return maxRow;
    }

    //TODO: Usar objeto nulo / Revisar que le gusta mas
    private Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        /* if (this.boardMap.containsKey(coordinate)){
            return this.boardMap.get(coordinate);
        } else {
            return Color.NULL;
        }*/

        return this.boardMap.containsKey(coordinate) ? this.boardMap.get(coordinate) : Color.NULL;
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    boolean isColumnFull(Coordinate coordinate) {
        return !this.boardMap.containsKey(new Coordinate(ROWS-1, coordinate.getColumn()));
    }

    boolean isConecta4(Color color) {
        assert !color.isNull();

        List<Direction> directions = this.getDirections(color);
        if (directions.size() < Coordinate.DIMENSION - 1) {
            return false;
        }
        for (int i = 0; i < directions.size() - 1; i++) {
            if (directions.get(i) != directions.get(i + 1)) {
                return false;
            }
        }
        return !directions.get(0).isNull();
    }

    private List<Direction> getDirections(Color color) {
        assert !color.isNull();

        List<Direction> directions = new ArrayList<>();
        List<Coordinate> coordinates = this.getCoordinates(color);
        if(!coordinates.isEmpty()){
            for (int i = 0; i < coordinates.size() - 1; i++) {
                directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
            }
        }
        return directions;
    }

    List<Coordinate> getCoordinates(Color color) {
        assert !color.isNull();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < Coordinate.ROWS; i++) {
            for (int j = 0; j < Coordinate.COLUMNS; j++) {
                if (this.getColor(new Coordinate(i,j)) == color) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }

    void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = ROWS-1; i >=0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < COLUMNS; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
