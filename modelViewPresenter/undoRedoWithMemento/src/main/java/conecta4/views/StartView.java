package conecta4.views;

import conecta4.controllers.StartController;
import conecta4.types.Message;

public class StartView {

    public void interact(StartController startController) {
        new MessageView().write(Message.TITLE);
        new BoardView().print(startController);
        startController.nextState();
    }
}
