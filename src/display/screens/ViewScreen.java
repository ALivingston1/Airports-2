package display.screens;

import display.components.AbstractScreen;
import display.components.DisplayBox;
import util.UI;

/**
 * This is the foundation screen to view airport, aircraft, or passenger (WIP)
 */
public class ViewScreen extends AbstractScreen {

    /**
     * Sets a parent screen to open back up onto when current one closes.
     * @param parent
     */
    public ViewScreen(AbstractScreen parent) {
        super(parent);
    }

    /**
     * Asks user to select what object they want to view, then opens corresponding screen
     * (Airport, Aircraft, Passenger (WIP).
     */
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
