package conecta4.views;

import conecta4.controllers.Logic;
import conecta4.types.Message;
import utils.views.YesNoDialog;

public class ResumeView extends WithLogicView {

    public ResumeView(Logic logic) {
        super(logic);
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.reset();
        }
        return isResumed.isAffirmative();
    }
}
