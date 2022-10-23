package conecta4.controllers;

import conecta4.models.Session;

public class StartController extends Controller implements AcceptorController {
    public StartController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
