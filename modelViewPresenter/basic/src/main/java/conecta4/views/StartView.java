package conecta4.views;

import conecta4.controllers.StartController;
import conecta4.types.Message;

public class StartView {

    private StartController startController;

    public StartView(StartController startController) {
        this.startController = startController;
    }

    public void interact() {
        new MessageView().write(Message.TITLE);
        new BoardView().print(startController);
    }
}
