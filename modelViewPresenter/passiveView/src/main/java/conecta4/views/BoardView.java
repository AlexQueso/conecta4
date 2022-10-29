package conecta4.views;

import conecta4.models.Board;
import conecta4.models.Coordinate;
import conecta4.types.Color;

import java.util.HashMap;
import java.util.Map;

public abstract class BoardView {
    protected Map<Coordinate, Color> colors;

    public BoardView() {
        this.colors = new HashMap<>();
    }

    public void set(Coordinate coordinate, Color color) {
        assert this.colors.size() < Board.COLUMNS * Board.ROWS;

        this.colors.put(coordinate, color);
    }

    public abstract void print();
}
