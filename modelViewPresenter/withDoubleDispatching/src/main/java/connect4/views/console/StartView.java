package connect4.views.console;

import connect4.controllers.StartController;
import connect4.types.Message;

public class StartView {

    public void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().print(startController);
        startController.nextState();
    }
}
