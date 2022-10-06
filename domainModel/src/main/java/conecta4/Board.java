package conecta4;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.ROWS][Coordinate.COLUMNS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.ROWS; i++) {
            for (int j = 0; j < Coordinate.COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    //TODO: Comparacion con objeto nulo
    void putToken(Coordinate coordinate, Color color) {
        assert !(coordinate == null);

        this.colors[calculateRow(coordinate)][coordinate.getColumn()] = color;
    }

    // TODO: Revisar bucle, asignación de fila y return si acaba el for
    private int calculateRow(Coordinate coordinate){
        for(int i = 0; i<Coordinate.ROWS; i++){
            if(this.colors[i][coordinate.getColumn()].isNull()){
                return i;
            }
        }

        return 0;
    }

    //TODO: Usar objeto nulo
    private Color getColor(Coordinate coordinate) {
        assert !(coordinate == null);

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    boolean isFull(Coordinate coordinate) {
        return !this.colors[Coordinate.ROWS-1][coordinate.getColumn()].isNull();
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
        for (int i = Coordinate.ROWS-1; i >=0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.COLUMNS; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
