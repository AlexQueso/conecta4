package conecta4.views;

import conecta4.models.Game;
import conecta4.models.Turn;
import org.apache.commons.lang.math.IntRange;

public class StartView extends WithGameView {
    public StartView(Game game) {
        super(game);
    }

    public void interact() {
        Message.TITLE.writeln();
        this.game.setPlayers(new RangeView(new IntRange(0, Turn.NUMBER_PLAYERS)).read(Message.NUMBER_PLAYERS.toString()));
        new BoardView(game).print();
    }
}
