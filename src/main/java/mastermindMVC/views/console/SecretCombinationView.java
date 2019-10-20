package mastermindMVC.views.console;

import mastermindMVC.controllers.Controller;
import mastermindMVC.models.Combination;
import mastermindMVC.models.SecretCombination;
import mastermindMVC.utils.Message;
import mastermindMVC.utils.WithConsoleModel;

public class SecretCombinationView extends WithConsoleModel {

    public void writeSecretCombination() {
        for (int i = 0; i < SecretCombination.getWidth(); i++) {
            this.console.write(Message.SECRET.getMessage());
        }
        this.console.write(Message.NEW_LINE.getMessage());
    }
}
