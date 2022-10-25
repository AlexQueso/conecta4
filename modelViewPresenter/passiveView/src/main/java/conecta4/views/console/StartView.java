package conecta4.views.console;

import conecta4.views.Message;

public class StartView implements conecta4.views.StartView {
    @Override
    public void write() {
        new MessageView().writeln(Message.TITLE);
    }
}
