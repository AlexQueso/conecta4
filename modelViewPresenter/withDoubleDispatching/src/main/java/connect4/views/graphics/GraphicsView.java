package connect4.views.graphics;

import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.views.View;

public class GraphicsView implements View {

    public void visit(StartController startController) {
    }

    public void visit(PlayController playController) {
    }

    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
