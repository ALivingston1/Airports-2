import Display.Admin.MenuScreen;
import Display.Customer.BuyTicketScreen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Which screen would you like to enter?");
        System.out.println("(1) Customer" + " ".repeat(6) + "(2) Admin" + " ".repeat(6) + "(3) Exit");

        getResponse();
    }

    public static void getResponse() {
        Scanner input = new Scanner(System.in);
        String response = input.next();

        if (response.equalsIgnoreCase("Customer") || response.equalsIgnoreCase("1")) {
            BuyTicketScreen screen = new BuyTicketScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Admin") || response.equalsIgnoreCase("2")) {
            MenuScreen screen = new MenuScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("3")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            getResponse();
        }
    }
}
