package conecta4.views;

import conecta4.models.Game;

public class MachinePlayerView extends PlayerView{

    MachinePlayerView(Game game) {
        super(game);
    }

    public int getColumn() {
        return this.game.getRandomColumn();
    }
}
