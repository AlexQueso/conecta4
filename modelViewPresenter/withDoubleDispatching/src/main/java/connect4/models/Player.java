package connect4.models;

import connect4.types.Color;

public class Player {
    private final Color color;

    public Player(Color color) {
        assert !color.isNull();

        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
