package conecta4.views;

import conecta4.models.Game;
import conecta4.types.PlayerType;

import java.util.HashMap;

public class PlayerViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewAsoc;

    PlayerViewPrototype(Game game) {
        this.playerViewAsoc = new HashMap<>();
        this.playerViewAsoc.put(PlayerType.USER, new UserPlayerView(game));
        this.playerViewAsoc.put(PlayerType.MACHINE, new MachinePlayerView(game));
    }

    PlayerView createView(PlayerType playerType) {
        return this.playerViewAsoc.get(playerType);
    }

}
