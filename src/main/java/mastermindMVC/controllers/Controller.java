package mastermindMVC.controllers;

import mastermindMVC.controllers.ControllerVisitor;
import mastermindMVC.models.ProposedCombination;
import mastermindMVC.models.Result;
import mastermindMVC.models.SecretCombination;
import mastermindMVC.models.Game;
import mastermindMVC.models.State;

import java.util.List;

public abstract class Controller {

    protected Game game;
    protected State state;

    public Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public int getAttempts(){
        return this.game.getAttemps();
    }

    public boolean isWinner() {
        return this.game.getResults().get(getAttempts() - 1).isWinner();
    }

    public List<ProposedCombination> getProposedCombinations(){
        return this.game.getProposedCombinations();
    }

    public List<Result> getResults(){
        return this.game.getResults();
    }

    public abstract void accept(ControllerVisitor controllerVisitor);

}