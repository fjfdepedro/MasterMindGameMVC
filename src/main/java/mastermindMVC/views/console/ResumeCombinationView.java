package mastermindMVC.views.console;

import java.util.List;

import mastermindMVC.controllers.Controller;
import mastermindMVC.controllers.ProposeCombinationController;
import mastermindMVC.models.ProposedCombination;
import mastermindMVC.models.Result;
import mastermindMVC.utils.Console;
import mastermindMVC.utils.Message;
import mastermindMVC.utils.WithConsoleModel;

public class ResumeCombinationView extends WithConsoleModel {
    private final Controller controller;

    public ResumeCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(int attempt) {
        Result result = this.controller.getResults().get(attempt);
        Console.writeln(Message.RESULT.getMessage().replaceFirst("#blacks", "" + result.getDeads())
                .replaceFirst("#whites", "" + result.getDamaged()));
    }
}