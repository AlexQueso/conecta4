package conecta4.views;

import conecta4.controllers.PlayController;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController){
        this.addCommand(new PutTokenCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}
