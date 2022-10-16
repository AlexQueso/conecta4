package conecta4.views;

import conecta4.controllers.Logic;
import conecta4.types.Message;

public class StartView extends WithLogicView {

    public StartView(Logic logic) {
        super(logic);
    }

    public void interact() {
        new MessageView().write(Message.TITLE);
        new BoardView().print(logic);
    }
}
