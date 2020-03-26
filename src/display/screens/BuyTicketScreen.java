package display.screens;

import display.components.AbstractBoxScreen;
import display.components.DisplayBox;
import util.Reference;
import util.UI;

import java.util.ArrayList;

public class BuyTicketScreen extends AbstractBoxScreen {
    private DisplayBox bookFlight;
    private DisplayBox pickAirline;
    private DisplayBox pickAirport;
    private DisplayBox ticket;

    private ArrayList<String> ticketInfo;

    public BuyTicketScreen() {
        ticketInfo = new ArrayList<>();

        //Creates new display box components with for various actions within screen
        bookFlight = new DisplayBox("Book A Flight");
        addBox(bookFlight);

        pickAirline = new DisplayBox("Which airline would you like to fly with?");
        for (String s : Reference.airlineList) {
            pickAirline.addData(s);
        }   //Add all of the airline options from the reference list
        addBox(pickAirline);

        pickAirport = new DisplayBox("Enter your departure airport.");
        for (int j = 0; j < (Reference.airportList.length * 3) / ((getMaxScreenWidth() / 4) - 1); j++) {

            String[] temp = Reference.airportList;
            String s = "";
            for (int i = j; i < (getMaxScreenWidth() / 4) - 1; i++) {
                s = s + temp[i];
            }
            pickAirport.addData(s);
        }
        addBox(pickAirport);

        ticket = new DisplayBox("Your ticket information.");

        //Finds the longest string contained in this screen and sets it as the width
        getMaxScreenWidth();
    }

    @Override
    public void open() {
        UI.clearScreen();

        bookFlight.draw();
        getAirline();
        getRoute();

        ticketInfo.add("Ticket Price: $" + UI.getRandomInt(400, 900));
        for (String s: ticketInfo) {
            ticket.addData(s);
        }
        ticket.draw();
    }

    /**Displays the Airline information
     * Asks user to pick an airline
     * stores answer.
     */
    private void getAirline() {
        pickAirline.draw();
        while (ticketInfo.isEmpty()) {
            String input = UI.getString();
            for (String s : Reference.airlineList) {
                if (input.equalsIgnoreCase(s)) {
                    ticketInfo.add(s);
                }
            }
        }
    }

    /**Displays list of airports
     * Asks user for arrival and departure airport
     * checks if inputs are duplicate, if true then
     * resets both variables and asks again.
     * Stores both values.
     */
    private void getRoute() {
        boolean flag = true;
        while (flag) {
            pickAirport.draw();
            while (ticketInfo.isEmpty()) {
                String input = UI.getString();
                for (String s : Reference.airportList) {
                    if (input.equalsIgnoreCase(s)) {
                        ticketInfo.add(s);
                    }
                }
            }

            pickAirport.setTitle("Enter your arrival airport.");
            pickAirport.draw();
            while (ticketInfo.isEmpty()) {
                String input = UI.getString();
                for (String s : Reference.airportList) {
                    if (input.equalsIgnoreCase(s)) {
                        ticketInfo.add(s);
                    }
                }
            }

            if (ticketInfo.get(2).equalsIgnoreCase(ticketInfo.get(1))) {
                System.out.println("You entered the same airport for both inputs. Please enter valid information.");
                ticketInfo.clear();
            } else {
                flag = false;
            }
        }   //Gets departure and arrival airports, checks for duplicates
    }

    /**
     * Checks every title and line of data in each box
     * to find the longest string, then sets it to
     * the screen's width so each box can be that
     * size.
     * @return int maxScreenWidth
     */
    private int getMaxScreenWidth() {
        for (DisplayBox box: boxes) {   //Checks each box
            if (box.getTitle().length() > width) {  //Checks each box title
                width = box.getTitle().length();
            }

            for (String s: box.getData()) { //Checks each line of data contained in the box
                if (s.length() > width) {
                    width = s.length();
                }
            }
        }
        return width;
    }
}
