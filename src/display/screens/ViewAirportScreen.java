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

        getAirport();
        displayBox.draw();
        System.out.println("Would you like to list its aircraft?");
        UI.draw("(1) Yes", "(2) No");
        String response = UI.getString();
        if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase(Integer.toString(1))) {
            if (airport.getAircraft().size() == 0) {
                System.out.println("No aircraft present at this airport.");
            } else {

                int i = 0;
                DisplayBox temp = new DisplayBox(airport.getIdentifier() + "'s Aircraft");
                for (IAircraft a : airport.getAircraft()) {
                    if (i < 5) {
                        temp.setData(temp.getNumSections(), temp.data.get(temp.getNumSections() - 1) + a.getFlightNumber() + " ");
                    } else {
                        temp.addData(a.getFlightNumber() + " ");
                        i = 0;
                    }
                    i++;
                }
                temp.draw();
            }

            System.out.println("Would you like to view any of these?");
            UI.draw("(1) Yes", "(2) No");
            response = UI.getString();
            if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase(Integer.toString(1))) {
                System.out.println("Which one?");

                response = UI.getString();
                for (IAircraft a : Reference.aircraftList) {
                    if (response.equalsIgnoreCase(a.getFlightNumber())) {
                        ViewAircraftScreen viewAircraftScreen = new ViewAircraftScreen(this, a);
                        viewAircraftScreen.open();
                    }
                }
            }

            UI.draw("(1) View another airport", "(2) Exit");
            response = UI.getString();

            if (response.equalsIgnoreCase("View another airport") || response.equalsIgnoreCase(Integer.toString(1))) {
                ViewScreen viewScreen = new ViewScreen(this);
                viewScreen.open();
            } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase(Integer.toString(2))) {
                super.close();
            }
        }
    }

    /**
     * Prompts user to type which airport to view.
     * Displays a list of all active airports.
     */
    private void getAirport() {
        DisplayBox airports = new DisplayBox("Which airport would you like to view?");
        String temp = "";
        for (int i = 0; i < Reference.airports.size(); i++) {
            temp = temp + Reference.airports.get(i).getIdentifier() + " ";
        }
        airports.addData(temp);
        airports.draw();

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
}
