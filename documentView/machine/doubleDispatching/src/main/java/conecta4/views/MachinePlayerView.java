package conecta4.views;

import conecta4.models.MachinePlayer;

public class MachinePlayerView extends PlayerView{
    public MachinePlayerView(MachinePlayer player) {
        super(player);
    }

    public int getColumn() {
        return ((MachinePlayer) this.player).getRandomColumn();
    }
}
