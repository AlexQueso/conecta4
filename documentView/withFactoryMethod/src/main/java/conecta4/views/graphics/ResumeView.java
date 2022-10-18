package conecta4.views.graphics;

import conecta4.views.Message;

import javax.swing.*;

public class ResumeView {
    private boolean newGame;

    ResumeView() {
        this.newGame = (JOptionPane.showConfirmDialog(null, Message.RESUME.toString(),
                Message.TITLE.toString(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

    boolean isResumedGame() {
        return this.newGame;
    }
}
