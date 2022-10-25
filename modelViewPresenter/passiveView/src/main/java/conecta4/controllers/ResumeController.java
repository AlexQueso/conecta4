package conecta4.controllers;

import conecta4.models.Game;
import conecta4.views.ViewFactory;

public class ResumeController extends Controller {

    public ResumeController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public boolean control() {
        boolean isResumed = this.viewFactory.createResumeView().read();
        if (isResumed) {
            this.game.reset();
        }
        return isResumed;
    }

}
