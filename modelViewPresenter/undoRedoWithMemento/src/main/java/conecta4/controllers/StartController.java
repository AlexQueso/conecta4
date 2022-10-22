package conecta4.controllers;

import conecta4.models.Game;
import conecta4.models.State;

public class StartController extends Controller implements AcceptorController {
    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
