package conecta4.views;

import conecta4.models.UserPlayer;

public class UserPlayerView extends PlayerView {
    public UserPlayerView(UserPlayer player) {
        super(player);
    }

     public int getColumn() {
        return new CoordinateView().read(Message.ENTER_COLUMN_TO_PUT.toString());
    }
}
