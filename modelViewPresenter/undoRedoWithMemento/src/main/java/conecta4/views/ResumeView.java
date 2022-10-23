package conecta4.views;

import conecta4.controllers.ResumeController;
import conecta4.types.Message;
import utils.views.YesNoDialog;

public class ResumeView{

    public void interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
    }
}
