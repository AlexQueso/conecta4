package conecta4.controllers;

import conecta4.models.Game;
import conecta4.views.ViewFactory;

public class StartController extends Controller {
    public StartController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public void control() {
        this.viewFactory.createStartView().write();
        this.writeBoard();
    }
}
