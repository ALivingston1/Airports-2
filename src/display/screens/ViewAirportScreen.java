package display.screens;

import display.components.AbstractBoxScreen;
import display.components.AbstractScreen;
import display.components.DisplayBox;
import system.Airport;
import system.aircraft.IAircraft;
import util.Reference;
import util.UI;

/**
 * This class is the foundation for viewing an airport
 * and lists each aircraft off if user selects to.
 */
public class ViewAirportScreen extends AbstractBoxScreen {
    private DisplayBox displayBox;
    private Airport airport;

    /**
     * Creates a new airport screen. With a parent screen to open back up when this is done being used.
     * @param parent
     */
    public ViewAirportScreen(AbstractScreen parent) {
        super(parent);
        displayBox = new DisplayBox("");
    }

    /**
     * Gets the airport the user wants.
     * Displays the airport.
     * Asks if the user wants a list of the aircraft in the airport.
     * If there is no aircraft in the airport, it will tell the user.
     * Asks if it user wants to view another airport, or exit.
     */
    @Override
    public void open() {
        super.open();

        initAirportList();
        getAirport();
        displayBox.draw();
        System.out.println("Would you like to list its " + airport.getAircraft().size() + " aircraft?");
        UI.draw("(1) Yes", "(2) No");
        String response = UI.getString();

        if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase(Integer.toString(1))) {
            if (airport.getAircraft().size() == 0) {
                System.out.println("No aircraft present at this airport.");

            } else {
                System.out.println(" ".repeat(30) + airport.getIdentifier() + "'s Aircraft:");

                for (int i = 0; i < airport.getAircraft().size() / 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(airport.getAircraft().get((i * 10) + j).getFlightNumber() + " ");
                    }
                    System.out.println();
                }
            }

            System.out.println("\nWould you like to view one of " + airport.getIdentifier() + "'s flights?");
            UI.draw("(1) Yes", "(2) No");
            response = UI.getString();
            if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase(Integer.toString(1))) {

                boolean flightNotFound = true;
                while (flightNotFound) {
                    System.out.print("Which flight: ");
                    response = UI.getString();

                    for (IAircraft a : Reference.aircraftList) {

                        if (response.equalsIgnoreCase(a.getFlightNumber())) {
                            flightNotFound = false;
                            ViewAircraftScreen viewAircraftScreen = new ViewAircraftScreen(this, a);
                            viewAircraftScreen.open();
                        }
                    }

                    if (flightNotFound) {
                        System.out.println("Flight not found, try again.");
                    }
                }
            }

        } else {
            boolean gettingResponse = true;

            while (gettingResponse) {
                System.out.println("Would you like to view another airport?");
                UI.draw("(1) Yes", "(2) No");
                response = UI.getString();

                if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase(Integer.toString(1))) {
                    this.open();
                } else if (response.equalsIgnoreCase("No") || response.equalsIgnoreCase(Integer.toString(2))) {
                    super.close();
                } else {
                    System.out.println("Response unknown, try again.");
                }
            }
        }
        super.close();
    }

    /**
     * Prompts user to type which airport to view.
     * Displays a list of all active airports.
     */
    private void getAirport() {
        if (displayBox.getNumSections() > 0) {
            displayBox.clear();
        }

        String response = UI.getString();
        for (Airport a : Reference.airports) {
            if (response.equalsIgnoreCase(a.getIdentifier())) {
                airport = a;
                displayBox.setTitle(a.getIdentifier());
                displayBox.addData("Aircraft Capacity: " + a.getCapacity());
                displayBox.addData("Towered: " + a.isTowered());
                break;
            }
        }

        if (airport == null) {
            System.out.println("Try again: ");
            getAirport();
        }
    }

    /**
     * Sets up the display box that
     * contains all of the active airports.
     * Box lists each active airport's identifier.
     */
    private void initAirportList() {
        DisplayBox airports = new DisplayBox("Which airport would you like to view?");
        String temp = "";
        for (int i = 0; i < Reference.airports.size(); i++) {
            temp = temp + Reference.airports.get(i).getIdentifier() + " ";
        }
        airports.addData(temp);
        airports.draw();
    }
}
