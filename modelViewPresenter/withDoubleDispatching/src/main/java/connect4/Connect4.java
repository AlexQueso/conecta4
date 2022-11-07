package connect4;

import connect4.controllers.*;
import connect4.views.View;
import connect4.views.console.ConsoleView;

abstract class Connect4 {
    private View view;
    private Logic logic;

    Connect4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.view);
        } while (controller != null);
    }
}