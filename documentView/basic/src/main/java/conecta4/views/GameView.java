package conecta4.views;

import conecta4.models.Game;

public class GameView extends WithGameView {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public GameView(Game game) {
        super(game);
        startView = new StartView(this.game);
        playView = new PlayView(this.game);
        resumeView = new ResumeView(this.game);
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
