package conecta4.models;

import conecta4.types.Color;

public class UserPlayer extends Player {

    @Override
    public void accept(PlayerVisitor playerVisitor) {
        playerVisitor.visit(this);
    }

    public UserPlayer(Color color, Board board) {
        super(color, board);
    }

    public Color getColor() {
        return color;
    }

}
