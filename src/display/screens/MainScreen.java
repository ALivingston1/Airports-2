package display.screens;

import display.components.AbstractBoxScreen;
import util.UI;

/**
 * This is the debug screen for this project.
 * Asks if we want to be a customer or an admin.
 * Will open up the corresponding screen.
 */
public class MainScreen extends AbstractBoxScreen {

    /**
     * This is the main screen, so it won't need a parent screen
     */
    public MainScreen() {
        super(null);
    }

    /**
     * Asks user to enter either "customer" or "admin" and will open
     * up the corresponding display or else it will close the screen
     * or ask to enter a new response if there is a typo.
     */
    @Override
    public void open() {
        super.open();
        System.out.println("Which screen would you like to enter?");
        System.out.println("(1) Customer" + " ".repeat(6) + "(2) Admin" + " ".repeat(6) + "(3) Exit");

        String response = UI.getString();
        if (response.equalsIgnoreCase("Customer") || response.equalsIgnoreCase("1")) {
            BuyTicketScreen screen = new BuyTicketScreen(this);
            screen.open();
        } else if (response.equalsIgnoreCase("Admin") || response.equalsIgnoreCase("2")) {
            AdminScreen screen = new AdminScreen(this);
            screen.open();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("3")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            open();
        }
    }
}
