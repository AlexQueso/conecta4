package connect4.controllers;

import connect4.models.Game;
import connect4.models.State;

public class ResumeController extends Controller{

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
