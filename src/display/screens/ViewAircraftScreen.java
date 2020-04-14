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
     * @param parent
     */
    public ViewAircraftScreen(AbstractScreen parent) {
        super(parent);
    }

    /**
     * Sets a parent screen to open back up onto when current one closes.
     * Will set the current aircraft to view by default.
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

            if (Reference.aircraftList.size() == 0) {
                System.out.println("There are no aircraft for you to view at this time.");
            } else {
                System.out.println("Which aircraft would you like to view?");

                String temp = "";
                for (IAircraft a : Reference.aircraftList) {
                    for (int i = 0; i < 100; i++) {
                        temp = temp + a.getFlightNumber() + " ";
                    }
                    System.out.print(temp);
                    temp = "\n";
                }

                String response = UI.getString();
                for (IAircraft a : Reference.aircraftList) {
                    if (response == a.getFlightNumber()) {
                        open();
                    }
                }
            }
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
    }
}
