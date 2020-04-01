package system;

import display.components.DisplayBox;
import display.components.IDisplayComponent;
import system.aircraft.airliner.Passenger;
import util.Reference;

import java.util.ArrayList;

public class Ticket implements IDisplayComponent {
    private String airline;
    private String arrAirport;
    private String depAirport;
    private int price;
    private ArrayList<String> info;

    private Passenger customer;
    private DisplayBox displayBox;

    public Ticket() {
        info = new ArrayList();
        if (customer != null) {
            info.add(customer.getName());
        } else {
            System.out.println("System error: Specific User is not logged in.\n");
        }
        info.add(airline);
        info.add(arrAirport);
        info.add(depAirport);
        info.add(Integer.toString(price));

        displayBox = new DisplayBox("Your ticket information.");
    }

    public void setAirline(String airline) {
        for (int i = 0; i < Reference.airlineList.length; i++) {
            if (airline.equals(Reference.airlineList[i])) {
                this.airline = airline;
            }
        }
    }

    public String getAirline() {
        return airline;
    }

    public void setDepAirport(String depAirport) {
        for (int i = 0; i < Reference.airportList.length; i++) {
            if (depAirport.equals(Reference.airportList[i])) {
                this.depAirport = depAirport;
            }
        }
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setArrAirport(String arrAirport) {
        for (int i = 0; i < Reference.airportList.length; i++) {
            if (arrAirport.equals(Reference.airportList[i])) {
                this.arrAirport = arrAirport;
            }
        }
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Checks what information has been filled out
     * in the ticket. If nothing has been filled out,
     * then displays 'blah: Not chosen'.
     * Sets title to similar structure.
     */
    private void refreshDisplay() {
        for (String data: info) {
            if (data.isEmpty() || data == null) {
                switch (info.indexOf(data)) {
                    case 0:
                        displayBox.setTitle("Customer Undefined" + "'s Ticket");

                    case 1:
                        displayBox.addData("Airline: Not chosen");

                    case 2:
                        displayBox.addData("Arrival Airport: Not chosen");

                    case 3:
                        displayBox.addData("Departure Airport: Not chosen");

                    case 4:
                        displayBox.addData("Ticket Price: Not chosen");
                }
            } else {
                switch (info.indexOf(data)) {
                    case 0:
                        displayBox.setTitle(customer.getName() + "'s Ticket");

                    case 1:
                        displayBox.setData(1, "Airline: " + airline);

                    case 2:
                        displayBox.setData(2,"Arrival Airport: " + arrAirport);

                    case 3:
                        displayBox.setData(3, "Departure Airport: " + depAirport);

                    case 4:
                        displayBox.setData(4,"Ticket Price: $" + price);
                }
            }
        }
    }

    /**
     * Wipes ticket data including graphics
     */
    public void clear() {
        airline = "";
        arrAirport = "";
        depAirport = "";
        price = 0;
    }

    @Override
    public void draw() {
        refreshDisplay();
        displayBox.draw();
    }
}
