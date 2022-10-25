package conecta4.views.console;

import conecta4.views.Message;
import utils.views.YesNoDialog;

public class ResumeView implements conecta4.views.ResumeView {
    public boolean read() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        return isResumed.isAffirmative();
    }
}
