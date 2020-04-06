package display.screens;

import display.components.AbstractScreen;
import display.components.DisplayBox;
import util.UI;

public class ViewScreen extends AbstractScreen {

    public ViewScreen(AbstractScreen parent) {
        super(parent);
    }
    @Override
    public void open() {
        super.open();

        DisplayBox b = new DisplayBox("View ");
        b.addData("(1) Airport (2) Aircraft (3) Exit");
        b.draw();

        String response = UI.getString();
        if (response.equalsIgnoreCase("Airport") || response.equalsIgnoreCase("1")) {
            ViewAirportScreen viewAirport = new ViewAirportScreen(this);
            viewAirport.open();
            close();
        } else if (response.equalsIgnoreCase("Aircraft") || response.equalsIgnoreCase("2")) {
            ViewAircraftScreen viewAircraft = new ViewAircraftScreen(this);
            viewAircraft.open();
            close();
        } else if (response.equalsIgnoreCase("Passenger") || response.equalsIgnoreCase("Passenger work in progress")) {
//            ViewPassengerScreen viewPassenger = new ViewPassengerScreen(this);
//            viewPassenger.open();
            close();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("3")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            open();
        }
    }
}
