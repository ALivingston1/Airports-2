package display.screens;

import display.components.AbstractBoxScreen;
import display.components.AbstractScreen;
import display.components.DisplayBox;
import system.Ticket;
import util.Reference;
import util.UI;

import java.util.Scanner;

/**
 * User end of the UI
 * Asks user for destination, departure, and airline
 * they want to choose.
 */
public class BuyTicketScreen extends AbstractBoxScreen {
    private DisplayBox bookFlight;
    private DisplayBox pickAirline;
    private DisplayBox pickAirport;

    public Ticket ticket;

    /**
     * Sets a parent screen to open back up onto when current one closes.
     * @param screen
     */
    public BuyTicketScreen(AbstractScreen screen) {
        super(screen);
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
        int section = 0;
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

    /**
     * Every time screen is opened
     * gets the maximum screen width
     * clears the console
     * gets all variables needed for
     * the ticket
     * displays the ticket
     */
    @Override
    public void open() {
        UI.clearScreen();

        getMaxScreenWidth();    //Finds longest string in the screen currently.
        bookFlight.draw();
        getAirline();
        getRoute();
        ticket.setPrice(UI.getRandomInt(400, 900));
        ticket.draw();

        close();
    }

    /**Displays the Airline information
     * Asks user to pick an airline
     * stores answer.
     */
    private void getAirline() {
        pickAirline.draw();

        boolean notValid = true;
        System.out.print("Select: ");
        while (notValid) {
            String input = UI.getString();
            for (String s : Reference.airlineList) {
                if (input.equalsIgnoreCase(s)) {
                    ticket.setAirline(s);
                    notValid = false;
                    break;
                } else {
                    System.out.print("Try again: ");
                    break;
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

            boolean departure = true;
            System.out.print("Select: ");
            while (departure) {
                String input = UI.getString();
                for (String s : Reference.airportList) {
                    if (input.equalsIgnoreCase(s)) {
                        ticket.setDepAirport(s);
                        departure = false;
                        break;
                    } else {
                        System.out.print("Try again: ");
                        break;
                    }
                }
            }

            pickAirport.setTitle("Enter your arrival airport.");

            pickAirport.draw();
            boolean arrival = true;
            System.out.print("Select: ");
            while (arrival) {
                String input = UI.getString();
                for (String s : Reference.airportList) {
                    if (input.equalsIgnoreCase(s)) {
                        ticket.setArrAirport(s);

                        /**
                         * Checks for duplicate inputs
                         */
                        if (ticket.getArrAirport().equalsIgnoreCase(ticket.getDepAirport())) {
                            System.out.println("You entered the same airport for both inputs. Please enter valid information.");
                            ticket.setDepAirport("");
                            ticket.setArrAirport("");
                            pickAirport.draw();
                            System.out.print("Try again: ");
                            break;
                        } else {
                            arrival = false;
                            flag = false;
                            break;
                        }
                    }
                }
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
