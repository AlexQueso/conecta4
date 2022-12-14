package connect4.views;

import connect4.controllers.PlayController;
import utils.views.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(PlayController playController){
        this.addCommand(new PutTokenCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}
