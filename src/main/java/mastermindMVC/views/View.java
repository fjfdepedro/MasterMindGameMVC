package mastermindMVC.views;

import mastermindMVC.controllers.*;

public interface View extends ControllerVisitor {
    void interact(Controller controller);
}
