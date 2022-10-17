package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Error;
import conecta4.types.PlayerType;

public abstract class Player {

    protected Color color;
    protected Board board;
    protected PlayerType type;
    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public PlayerType getType() {
        return this.type;
    }
}
