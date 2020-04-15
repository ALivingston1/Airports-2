package display.screens;

import display.components.AbstractBoxScreen;
import display.components.AbstractScreen;
import display.components.DisplayBox;
import system.aircraft.airliner.Passenger;
import util.UI;

/**
 * Asks which passenger to view
 * Displays information of passenger (if one exists)
 */
public class ViewPassengerScreen extends AbstractBoxScreen {
    private Passenger passenger;

    /**
     * Constructor.
     * Gets a parent screen to open on when the current one is done being opened.
     *
     * @param parent
     */
    public ViewPassengerScreen(AbstractScreen parent) {
        super(parent);
    }

    /**
     * Opens the passenger screen
     */
    @Override
    public void open() {
        super.open();

        DisplayBox displayBox = new DisplayBox("");

        boolean flag = true;
        while (flag) {
            if (passenger == null) {
                passenger = UI.getPassenger();
                continue;
            } else {
                displayBox.setTitle(passenger.getName() + "'s Information");
                displayBox.addData("Name: " + passenger.getName());
                displayBox.addData("Seating: " + passenger.getSeat());

                displayBox.draw();
                flag = false;
                break;
            }
        }
    }
}
