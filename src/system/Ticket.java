package system;

import display.components.DisplayBox;
import display.components.IDisplayComponent;
import system.aircraft.airliner.Passenger;
import util.Reference;

import java.util.ArrayList;

public class Ticket implements IDisplayComponent {
    private ArrayList<String> info;

    private Passenger customer;
    private DisplayBox displayBox;

    public Ticket() {
        info = new ArrayList();
        displayBox = new DisplayBox("");

        info.add(displayBox.data.get(0));
    }

    public void setAirline(String airline) {
        for (int i = 0; i < Reference.airlineList.length; i++) {
            if (airline.equals(Reference.airlineList[i])) {
                if (info.size() < 2) {
                    info.add(1, airline);
                    displayBox.addData("Airline: " + info.get(0));
                } else {
                    info.set(1, airline);
                }
            }
        }
    }

    public String getAirline() {
        return info.get(1);
    }

    public void setDepAirport(String depAirport) {
        for (int i = 0; i < Reference.airportList.length; i++) {
            if (depAirport.equals(Reference.airportList[i])) {
                if (info.size() < 3) {
                    info.add(2, depAirport);
                    displayBox.addData("Departure Airport: " + info.get(2));
                } else {
                    info.set(2, depAirport);
                }
            }
        }
    }

    public String getDepAirport() {
        return info.get(2);
    }

    public void setArrAirport(String arrAirport) {
        for (int i = 0; i < Reference.airportList.length; i++) {
            if (arrAirport.equals(Reference.airportList[i])) {
                if (info.size() < 4) {
                    info.add(3, arrAirport);
                    displayBox.addData("Arrival Airport: " + info.get(1));
                } else {
                    info.set(3, arrAirport);
                }
            }
        }
    }

    public String getArrAirport() {
        return info.get(3);
    }

    public void setPrice(int price) {
        if (info.size() < 5) {
            info.add(4, Integer.toString(price));
            displayBox.addData("Ticket Price: $" + info.get(3));
        } else {
            info.set(4, Integer.toString(price));
        }
    }

    public String getPrice() {
        return info.get(4);
    }

    private String getCustomerName() {
        String name;
        if (customer == null) {
            System.out.println("System error: Specific User is not logged in.\n");
            name = "undefined";
        } else {
            name = customer.getName();
        }
        return name;
    }

    /**
     * Checks what information has been filled out
     * in the ticket. If nothing has been filled out,
     * then displays 'blah: Not chosen'.
     * Sets title to similar structure.
     */
    private void refreshDisplay() {
        for (int i = 0; i < info.size(); i++) {
            switch (i) {
                case 0:
                    displayBox.setTitle(getCustomerName() + "'s Ticket");
                    break;

                case 1:
                    displayBox.setData(1, "Airline: " + info.get(1));
                    break;

                case 2:
                    displayBox.setData(2, "Departure Airport: " + info.get(2));
                    break;

                case 3:
                    displayBox.setData(3, "Arrival Airport: " + info.get(3));
                    break;

                case 4:
                    displayBox.setData(4, "Ticket Price: $" + info.get(4));
                    break;
            }
        }
    }

    /**
     * Wipes ticket data including graphics
     */
    public void clear() {
        info.clear();
    }

    @Override
    public void draw() {
        refreshDisplay();
        displayBox.draw();
    }
}
