import display.screens.AdminScreen;
import display.screens.BuyTicketScreen;
import util.UI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Which screen would you like to enter?");
        System.out.println("(1) Customer" + " ".repeat(6) + "(2) Admin" + " ".repeat(6) + "(3) Exit");

        getResponse();
    }

    public static void getResponse() {
        String response = UI.getString();

        if (response.equalsIgnoreCase("Customer") || response.equalsIgnoreCase("1")) {
            BuyTicketScreen screen = new BuyTicketScreen();
            UI.clearScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Admin") || response.equalsIgnoreCase("2")) {
            AdminScreen screen = new AdminScreen();
            UI.clearScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("3")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            getResponse();
        }
    }
}
