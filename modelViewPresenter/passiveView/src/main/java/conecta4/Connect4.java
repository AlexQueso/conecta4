package conecta4;

import conecta4.controllers.PlayController;
import conecta4.controllers.ResumeController;
import conecta4.controllers.StartController;
import conecta4.models.Game;
import conecta4.views.ViewFactory;

abstract class Connect4 {

    private Game game;
    private ViewFactory viewFactory;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    Connect4() {
        this.game = new Game();
        this.viewFactory = this.createViewFactory();
        this.startController = new StartController(this.game, this.viewFactory);
        this.playController = new PlayController(this.game, this.viewFactory);
        this.resumeController = new ResumeController(this.game, this.viewFactory);
    }

    protected abstract ViewFactory createViewFactory();

    protected void play() {
        do {
            this.startController.control();
            this.playController.control();
        } while (this.resumeController.control());
    }
}