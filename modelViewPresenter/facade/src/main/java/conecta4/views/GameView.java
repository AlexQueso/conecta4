package conecta4.views;

import conecta4.controllers.Logic;

public class GameView extends WithLogicView {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public GameView(Logic logic) {
        super(logic);
        this.startView = new StartView(logic);
        this.playView = new PlayView(logic);
        this.resumeView = new ResumeView(logic);
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
