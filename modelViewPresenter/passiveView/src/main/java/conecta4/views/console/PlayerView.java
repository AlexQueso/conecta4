package conecta4.views.console;

import conecta4.types.Color;
import conecta4.views.Message;

public class PlayerView implements conecta4.views.PlayerView {
    @Override
    public void writeWinner(Color color) {
        new MessageView().writeln(Message.PLAYER_WIN, color.name());
    }

    @Override
    public void writeTie() {
        new MessageView().writeln(Message.TIE);
    }
}
