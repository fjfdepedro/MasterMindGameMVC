
package mastermindMVC;

import mastermindMVC.controllers.Controller;
import mastermindMVC.controllers.Logic;
import mastermindMVC.views.View;
import mastermindMVC.views.console.ConsoleView;

public class Mastermind {

    private Logic logic;
    private View view;

    public Mastermind() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    public void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null){
                this.view.interact(controller);
            }
        } while (controller != null);
    }
}