package conecta4.views;

import conecta4.models.Player;
import conecta4.types.Error;

public abstract class PlayerView {

    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    public void interact() {
        int column;
        Error error;
        do {
            column = getColumn();
            error = getFullColumnError(column);
            if (!error.isNull()) {
                new ErrorView().writeln(error);
            }
        } while (!error.isNull());
        this.player.putToken(column);
    }

    protected abstract int getColumn();

    private Error getFullColumnError(int column) {
        return this.player.getColumnFullError(column);
    }
}
