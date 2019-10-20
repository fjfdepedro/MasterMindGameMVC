package mastermindMVC.views.console;

import mastermindMVC.controllers.Controller;
import mastermindMVC.models.*;
import mastermindMVC.models.Error;
import mastermindMVC.utils.Console;
import mastermindMVC.utils.Message;
import mastermindMVC.utils.ValidatorCombination;
import mastermindMVC.utils.WithConsoleModel;

import java.util.ArrayList;
import java.util.List;

public class ProposeCombinationView extends WithConsoleModel {

    private final Controller controller;

    public ProposeCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void write(int attempt) {
        ProposedCombination proposedCombination = this.controller.getProposedCombinations().get(attempt);
        for (Color color : proposedCombination.getColors()) {
            this.console.write(color.getColor());
        }
    }

    public ProposedCombination validate() {
        Error error;
        List<Color> colors = new ArrayList<Color>();
        do {
            error = null;
            Console.write(Message.PROPOSED_COMBINATION.getMessage());
            String characters = Console.readString();

            ValidatorCombination validateCombination = new ValidatorCombination(characters, Combination.NUMBER_ITEMS);

            if (!validateCombination.checkNumberItemsColorIsOk()) {
                error = Error.WRONG_LENGTH;
            }
            else if (!validateCombination.checkValidColor()) {
                error = Error.WRONG_CHARACTERS;
            }
            else if (validateCombination.checkRepeatedColor()) {
                error = Error.DUPLICATED;
            }
            else {
                for (int i = 0; i < characters.length(); i++) {
                    Color color = Color.getColor(characters.charAt(i));
                    colors.add(color);
                }
            }

            if (error != null) {
                Console.writeln(error.getMessage());
            }
        } while (error != null);
        return new ProposedCombination(colors);
    }
}