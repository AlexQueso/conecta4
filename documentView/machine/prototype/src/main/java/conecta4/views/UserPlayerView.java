package conecta4.views;


import conecta4.models.Game;

public class UserPlayerView extends PlayerView {
    UserPlayerView(Game game) {
        super(game);
    }

    public int getColumn() {
        return new CoordinateView(this.game).read(Message.ENTER_COLUMN_TO_PUT.toString());
    }
}
