package conecta4.views.console;

import conecta4.models.Game;
import conecta4.views.Message;
import conecta4.views.WithGameView;
import utils.views.YesNoDialog;

public class ResumeView extends WithGameView {
    public ResumeView(Game game) {
        super(game);
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.game.reset();
        }
        return isResumed.isAffirmative();
    }
}
