package conecta4.models;

import conecta4.types.Color;
import conecta4.types.PlayerType;

public class UserPlayer extends Player {

    public UserPlayer(Color color, Board board) {
        super(color, board);
        this.type = PlayerType.USER;
    }

    public Color getColor() {
        return color;
    }

}
