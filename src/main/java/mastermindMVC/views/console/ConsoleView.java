package mastermindMVC.views.console;

import mastermindMVC.controllers.Controller;
import mastermindMVC.controllers.ProposeCombinationController;
import mastermindMVC.controllers.ResumeController;
import mastermindMVC.controllers.StartController;
import mastermindMVC.models.ProposedCombination;
import mastermindMVC.utils.Console;
import mastermindMVC.utils.Message;
import mastermindMVC.utils.YesNoDialog;
import mastermindMVC.views.View;
import mastermindMVC.views.console.GameView;
import mastermindMVC.views.console.SecretCombinationView;

public class ConsoleView implements View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeTitle();
        new SecretCombinationView().writeSecretCombination();
    }

    @Override
    public void visit(ProposeCombinationController proposeCombinationController) {
        ProposedCombination proposedCombination = new ProposeCombinationView(proposeCombinationController).validate();
        proposeCombinationController.addProposedCombination(proposedCombination);
        new GameView(proposeCombinationController).writeAttempts();
    }

    @Override
    public void visit(ResumeController resumeController) {
        new GameView(resumeController).writeResultPlay();
        resumeController.resume(new YesNoDialog().read(Message.RESUME.getMessage()));
    }
}