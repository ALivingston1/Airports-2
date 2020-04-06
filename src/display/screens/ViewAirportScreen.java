package display.screens;

import display.components.AbstractBoxScreen;
import display.components.AbstractScreen;
import display.components.DisplayBox;
import system.Airport;
import util.Reference;
import util.UI;

public class ViewAirportScreen extends AbstractBoxScreen {
    private DisplayBox displayBox;
    private Airport airport;

    public ViewAirportScreen(AbstractScreen parent) {
        super(parent);
        displayBox = new DisplayBox("");
    }

    @Override
    public void open() {
        super.open();

        getAirport();
        displayBox.draw();
        System.out.println("Would you like to view its aircraft?");
        String response = UI.getString();
        if (response.equalsIgnoreCase("Yes") || response == Integer.toString(1)) {
//            ViewAircraftScreen viewAircraft = new ViewAircraftScreen(this);
        } else {
            UI.draw("(1) View Another", "(2) Exit");
            response = UI.getString();

            if (response.equalsIgnoreCase("View another") || response == Integer.toString(1)) {
                ViewScreen viewScreen = new ViewScreen(this);
                viewScreen.open();
            } else if (response.equalsIgnoreCase("Exit") || response == Integer.toString(2)) {
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
