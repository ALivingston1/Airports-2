import display.screens.AdminScreen;
import display.screens.BuyTicketScreen;
import system.Airport;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;
import util.Reference;
import util.UI;

public class Main {
    public static void main(String[] args) {
        initSystem();

        System.out.println("Which screen would you like to enter?");
        System.out.println("(1) Customer" + " ".repeat(6) + "(2) Admin" + " ".repeat(6) + "(3) Exit");

        getResponse();
    }

    public static void getResponse() {
        String response = UI.getString();

        if (response.equalsIgnoreCase("Customer") || response.equalsIgnoreCase("1")) {
            BuyTicketScreen screen = new BuyTicketScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Admin") || response.equalsIgnoreCase("2")) {
            AdminScreen screen = new AdminScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("3")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            getResponse();
        }
    }

    public static void initSystem() {
        for (String s : Reference.airportList) {
            Reference.airports.add(new Airport(s));
        }

        for (Airport a : Reference.airports) {
            for (int i = 0; i < Reference.airportList.length; i++) {
                for (int j = 0; j < Reference.airportList.length; j++) {
                    if (i != j) {
                        a.addAircraft(new Airliner());
                        a.addAircraft(new CargoTransporter());
                    }
                }
            }
        }
    }
}
