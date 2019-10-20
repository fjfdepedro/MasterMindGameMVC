package mastermindMVC.controllers;

import mastermindMVC.controllers.Controller;
import mastermindMVC.models.Game;
import mastermindMVC.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.state.next();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}