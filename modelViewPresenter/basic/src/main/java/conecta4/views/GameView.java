package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.controllers.ResumeController;
import conecta4.controllers.StartController;
import conecta4.models.Game;

public class GameView{

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public GameView(StartController startController, PlayController playController, ResumeController resumeController) {
        this.startView = new StartView(startController);
        this.playView = new PlayView(playController);
        this.resumeView = new ResumeView(resumeController);
    }

    public void start() {
        startView.interact();
    }

    public void play() {
        playView.interact();
    }

    public boolean resume() {
        return resumeView.interact();
    }
}
