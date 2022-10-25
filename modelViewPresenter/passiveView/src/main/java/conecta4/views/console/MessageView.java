package conecta4.views.console;

import conecta4.views.Message;
import utils.views.Console;

public class MessageView {

    void write(Message message) {
        Console.getInstance().write(message.toString());
    }

    void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

    void writeln(Message message, String player) {
        assert message == Message.PLAYER_WIN;

        Console.getInstance().writeln(message.toString().replaceAll("#player", "" + player));
    }
}
