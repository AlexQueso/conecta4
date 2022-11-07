package connect4.controllers;

public interface ControllersVisitor {

    void visit(StartController startController);
    void visit(PlayController playController);
    boolean visit(ResumeController resumeController);

}
