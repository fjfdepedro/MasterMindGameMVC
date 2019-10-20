package mastermindMVC.views.console;

import mastermindMVC.controllers.Controller;
import mastermindMVC.utils.Console;
import mastermindMVC.utils.Message;
import mastermindMVC.utils.WithConsoleModel;

public class GameView extends WithConsoleModel {

    private final Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void writeAttempts() {
        Console.writeln(Message.ATTEMPTS.getMessage().replaceAll("#attempts", "" + this.controller.getAttempts()));
        new SecretCombinationView().writeSecretCombination();
        for (int i = 0; i < this.controller.getAttempts(); i++) {
            new ProposeCombinationView(this.controller).write(i);
            new ResumeCombinationView(this.controller).writeln(i);
        }
    }

    public void writeTitle() {
        Console.writeln(Message.TITLE.getMessage());
    }

    public void writeResultPlay() {
        if (this.controller.isWinner())
            Console.writeln(Message.WINNER.getMessage());
        else
            Console.writeln(Message.LOOSER.getMessage());
    }
}
