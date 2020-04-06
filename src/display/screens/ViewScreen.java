package display.screens;

import display.components.AbstractScreen;
import util.UI;

public class ViewScreen extends AbstractScreen {

    public ViewScreen(AbstractScreen parent) {
        super(parent);
    }
    @Override
    public void open() {
        super.open();

        UI.draw("(1) Airport", "(2) Aircraft", "(3) Passenger", "(4) Exit");

        String response = UI.getString();
        if (response.equalsIgnoreCase("Airport") || response.equalsIgnoreCase("1")) {
            ViewAirportScreen viewAirport = new ViewAirportScreen(this);
            viewAirport.open();
            close();
        } else if (response.equalsIgnoreCase("Aircraft") || response.equalsIgnoreCase("2")) {
//            ViewAircraftScreen viewAircraft = new ViewAircraftScreen(this);
//            viewAircraft.open();
            close();
        } else if (response.equalsIgnoreCase("Passenger") || response.equalsIgnoreCase("3")) {
//            ViewPassengerScreen viewPassenger = new ViewPassengerScreen(this);
//            viewPassenger.open();
            close();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("4")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            open();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
