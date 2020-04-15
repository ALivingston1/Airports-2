package display.screens;

import display.components.AbstractBoxScreen;
import display.components.AbstractScreen;
import display.components.DisplayBox;
import system.Airport;
import system.aircraft.IAircraft;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;
import util.Reference;
import util.UI;

/**
 * This screen allows the user to view aircraft in a specified airport.
 */
public class ViewAircraftScreen extends AbstractBoxScreen {
    private IAircraft aircraft;

    /**
     * Sets a parent screen to open back up onto when current one closes.
     *
     * @param parent
     */
    public ViewAircraftScreen(AbstractScreen parent) {
        super(parent);
    }

    /**
     * Sets a parent screen to open back up onto when current one closes.
     * Will set the current aircraft to view by default.
     *
     * @param parent
     * @param aircraft
     */
    public ViewAircraftScreen(AbstractScreen parent, IAircraft aircraft) {
        super(parent);
        this.aircraft = aircraft;
    }

    /**
     * Will setup all of the display info for each
     * aircraft. Will look at the reference list of all current
     * airports in the system and then create semi-random aircraft based
     * off of the data.
     */
    @Override
    public void open() {
        super.open();

        DisplayBox displayBox = new DisplayBox("");

        if (aircraft == null) {
            Airport airport = UI.getAirport();
            UI.listAircraft(airport);

        } else if (aircraft instanceof Airliner) {
            displayBox.setTitle("Flight " + aircraft.getFlightNumber());
            displayBox.addData("Airline: " + ((Airliner) aircraft).getAirline());
            displayBox.addData("Departure Airport: " + aircraft.getOrigin());
            displayBox.addData("Arrival Airport: " + aircraft.getDestination());
            displayBox.addData("Souls on board: " + ((Airliner) aircraft).getNumSouls());
            displayBox.addData("Gingers on board: " + (((Airliner) aircraft).getNumSouls() - ((Airliner) aircraft).getNumBodies()));
            displayBox.addData("Aircraft Make: " + aircraft.getMake());
            displayBox.addData("Aircraft Model: " + aircraft.getModel());
            displayBox.addData("Weight capacity: " + aircraft.getWeightCapacity());

            displayBox.draw();

        } else if (aircraft instanceof CargoTransporter) {
            displayBox.setTitle("Flight " + aircraft.getFlightNumber());
            displayBox.addData("Departure Airport: " + aircraft.getOrigin());
            displayBox.addData("Arrival Airport: " + aircraft.getDestination());
            displayBox.addData("Aircraft Make: " + aircraft.getMake());
            displayBox.addData("Aircraft Model: " + aircraft.getModel());
            displayBox.addData("Weight capacity: " + aircraft.getWeightCapacity());

            displayBox.draw();
        }

        System.out.println("Would you like to view a list of " + aircraft.getFlightNumber() + "'s passengers?");
        UI.draw("(1) Yes", "(2) No");
        boolean flag = true;
        while (flag) {
            String response = UI.getString();
            if (response.equalsIgnoreCase("Yes") || response.equalsIgnoreCase("1")) {
                ViewPassengerScreen screen = new ViewPassengerScreen(this);
                screen.open();

                flag = false;
            } else if (response.equalsIgnoreCase("No") || response.equalsIgnoreCase("2")) {
                flag = false;
            } else {
                System.out.print("\nTry again: ");
            }
        }
    }
}
