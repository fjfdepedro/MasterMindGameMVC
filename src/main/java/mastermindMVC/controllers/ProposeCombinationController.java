package mastermindMVC.controllers;

import mastermindMVC.controllers.Controller;
import mastermindMVC.models.*;

import java.util.List;


public class ProposeCombinationController extends Controller {

    public ProposeCombinationController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.getProposedCombinations().add(proposedCombination);
        Result result = this.game.getSecretCombination().calculateResult(proposedCombination);
        this.game.getResults().add(result);
        if (this.game.isFinished())
            this.state.next();
    }

}