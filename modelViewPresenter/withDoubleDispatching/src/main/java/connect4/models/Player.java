package connect4.models;

import connect4.types.Color;

public class Player {
    private final Color color;
    private final Board board;

    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

}
