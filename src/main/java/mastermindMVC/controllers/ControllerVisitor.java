package mastermindMVC.controllers;

public interface ControllerVisitor {

    void visit(StartController startController);
    void visit(ProposeCombinationController proposeCombinationController);
    void visit(ResumeController resumeController);

}
