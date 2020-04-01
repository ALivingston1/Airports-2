package display.screens;

import display.components.AbstractBoxScreen;
import display.components.DisplayBox;
import system.Ticket;
import util.Reference;
import util.UI;

public class BuyTicketScreen extends AbstractBoxScreen {
    private DisplayBox bookFlight;
    private DisplayBox pickAirline;
    private DisplayBox pickAirport;

    public Ticket ticket;

    public BuyTicketScreen() {
        ticket = new Ticket();

        //Creates new display box components with for various actions within screen
        bookFlight = new DisplayBox("Book A Flight");
        pickAirline = new DisplayBox("Which airline would you like to fly with?");
        pickAirport = new DisplayBox("Enter your departure airport.");

        //Adds each display box to the list of boxes in the screen
        addBox(bookFlight);
        addBox(pickAirline);
        addBox(pickAirport);

        //Add all of the data to each display box
        for (String s : Reference.airlineList) {
            pickAirline.addData(s);
        }

        String prev = "";
        int section = 1;
        for (String curr : Reference.airportList) {
            //If there are 0 or 1 section(s), then it adds a new one with the airport name in it.
            if (pickAirport.getNumSections() == 1 || (prev.length() + curr.length() + 1) > getMaxScreenWidth()) {
                pickAirport.addData(curr + " ");
                prev = curr + " ";
                section++;
            } else {
                pickAirport.setData(section, prev + curr + " ");
                prev+= curr + " ";
            }
        }
    }

    @Override
    public void open() {
        //Finds the longest string contained in this screen and sets it as the width
        getMaxScreenWidth();

        UI.clearScreen();

        bookFlight.draw();
        getAirline();
        getRoute();
        ticket.setPrice(UI.getRandomInt(400, 900));

        ticket.draw();
    }

    /**Displays the Airline information
     * Asks user to pick an airline
     * stores answer.
     */
    private void getAirline() {
        pickAirline.draw();
        while (ticket.getAirline() == null) {
            System.out.print("Select: ");
            String input = UI.getString();
            for (String s : Reference.airlineList) {
                if (input.equalsIgnoreCase(s)) {
                    ticket.setAirline(s);
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
            while (ticket.getDepAirport() == null || ticket.getDepAirport() == "") {
                System.out.print("Select: ");
                String input = UI.getString();
                for (String s : Reference.airportList) {
                    if (input.equalsIgnoreCase(s)) {
                        ticket.setDepAirport(s);
                    }
                }
            }

            pickAirport.setTitle("Enter your arrival airport.");
            pickAirport.draw();
            while (ticket.getArrAirport() == null || ticket.getArrAirport() == "") {
                System.out.print("Select: ");
                String input = UI.getString();
                for (String s : Reference.airportList) {
                    if (input.equalsIgnoreCase(s)) {
                        ticket.setArrAirport(s);
                    }
                }
            }

            if (ticket.getArrAirport().equalsIgnoreCase(ticket.getDepAirport())) {
                System.out.println("You entered the same airport for both inputs. Please enter valid information.");
                ticket.clear();
                UI.clearScreen();
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

            for (String s: box.data) { //Checks each line of data contained in the box
                if (s.length() > width) {
                    width = s.length();
                }
            }
        }
        return width;
    }
}
