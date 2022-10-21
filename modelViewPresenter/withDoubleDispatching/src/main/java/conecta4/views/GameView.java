package conecta4.views;

import conecta4.controllers.*;

public class GameView extends WithLogicView implements ControllersVisitor {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public GameView(Logic logic) {
        super(logic);
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        this.playView.interact(playController);
    }

    @Override
    public boolean visit(ResumeController resumeController) {
        return this.resumeView.interact(resumeController);
    }
}
