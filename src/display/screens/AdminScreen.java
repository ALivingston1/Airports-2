package display.screens;

import display.components.AbstractScreen;
import display.components.DisplayBox;
import util.UI;

public class AdminScreen extends AbstractScreen {

    public AdminScreen(AbstractScreen screen) {
        super(screen);
    }

    @Override
    public void open() {
        super.open();
        DisplayBox god = new DisplayBox("Welcome to the god screen.");
        god.draw();

        System.out.println("What would you like to do?");
        UI.draw("(1) View", "(2) Exit");

        String response = UI.getString();
        if (response.equalsIgnoreCase("View") || response.equalsIgnoreCase("1")) {
            ViewScreen view = new ViewScreen(this);
            view.open();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("2")) {
            System.out.println("Closing...");
            close();
        } else {
            System.out.println("Please type a valid response.");
            open();
        }
    }
}
