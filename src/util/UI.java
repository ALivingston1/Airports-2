package util;

import system.Airport;
import system.aircraft.IAircraft;
import system.aircraft.IPerson;
import system.aircraft.airliner.Passenger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Static class for helpful things
 * like getting user input for strings,
 * integers,
 * and can draw multiple strings with spacing in between.
 * Also can get the mas length of an arraylist of strings.
 */
public class UI {

    /**
     * Private for safety to never make an object of this class.
     */
    private UI() {

    }

    /**
     * Clears the console to prep for a new Screen.
     * ONLY WORKS IN CMD LINE
     */
    public static void clearScreen() {
        /*
        Clear console
         */
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Requests integer from the user.
     * @return int typed.
     */
    public static int getInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Finds the longest string in an ArrayList.
     * @param strings
     * @return length of longest string
     */
    public static int getMaxStringLen(ArrayList<String> strings) {
        int counter = 0;
        for (String s: strings) {
            if (s.length() > counter) {
                counter = s.length();
            }
        }
        return counter;
    }

    /**
     * Gets a random integer within bounds of two numbers.
     * Generates new random ints until one is >= minimum bound
     * and <= maximum bound.
     * @param min
     * @param max
     * @return int
     */
    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        int temp = r.nextInt(max);

        boolean outOfBounds = true;
        while (outOfBounds) {
            if (temp < min) {
                temp = r.nextInt(max);
            } else {
                outOfBounds = false;
            }
        }
        return temp;
    }

    /**
     * Requests String from the user.
     * @return String typed.
     */
    public static String getString() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    /**
     * Requests airport identifier from list the of active airport.
     * @return airport
     */
    public static Airport getAirport() {
        Airport temp = null;
        if (Reference.airports == null) {
            System.out.println("Error: no airports exist.");
            return null;
        } else {
            String response = UI.getString();
            for (Airport a : Reference.airports) {
                if (response.equalsIgnoreCase(a.getIdentifier())) {
                    temp = a;
                    break;
                } else {
                    temp = null;
                }
            }
            return temp;
        }
    }

    /**
     * Requests aircraft flight number from list of the active aircraft.
     * @return aircraft
     */
    public static IAircraft getAircraft() {
        IAircraft temp = null;
        if (Reference.aircraftList == null) {
            System.out.println("Error: no aircraft exist.");
            return null;
        } else {
            String response = UI.getString();
            for (IAircraft a : Reference.aircraftList) {
                if (response.equalsIgnoreCase(a.getFlightNumber())) {
                    temp = a;
                } else {
                    temp = null;
                }
            }
            return temp;
        }
    }

    /**
     * Requests aircraft flight number from list of the active aircraft.
     * @return aircraft
     */
    public static Passenger getPassenger() {
        Passenger temp = null;
        if (Reference.passengers == null) {
            System.out.println("Error: no passengers exist.");
            return null;
        } else {
            String response = UI.getString();
            for (Passenger p : Reference.passengers) {
                if (response.equalsIgnoreCase(p.getName())) {
                    temp = p;
                }
            }
            return temp;
        }
    }

    /**
     * Prints all aircraft in an airport
     * @param airport
     */
    public static void listAircraft(Airport airport) {
        if (airport.getAircraft().size() == 0) {
            System.out.println("No aircraft present at this airport.");

        } else {
            System.out.println(" ".repeat(30) + airport.getIdentifier() + "'s Aircraft:");

            for (int i = 0; i < airport.getAircraft().size() / 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(airport.getAircraft().get((i * 10) + j).getFlightNumber() + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Displays each string put into the method.
     * @param strings
     */
    public static void draw(String ...strings) {
        for (String s: strings) {
            System.out.print(s + " ".repeat(6));
        }
        System.out.println();
    }
}
