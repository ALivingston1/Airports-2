package display.screens;

import display.components.AbstractBoxScreen;
import display.components.AbstractScreen;
import util.UI;

public class MainScreen extends AbstractBoxScreen {
    public MainScreen() {
        super(null);
    }

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
