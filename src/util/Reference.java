package util;

import system.Airport;
import system.aircraft.IAircraft;

import java.util.ArrayList;

/**
 * Reference class for current airports, aircraft, and
 * includes static references for airport identifiers, airline list,
 * make and models of aircraft within the system.
 */
public class Reference {
    public static String[] airportList = {"ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR", "CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA", "MDW", "TPA", "PDX", "HNL"};
    public static String[] airlineList = {"Spirit", "American", "United", "SouthWest"};
    public static String[] airlineAbbreviation = {"NK", "AA", "UA", "SW", "DL"};
    public static ArrayList<IAircraft> aircraftList = new ArrayList<>();
    public static String[] make = {"Boeing", "Airbus"};
    public static String[] model = {"737", "747", "767", "777", "A300", "A330", "A350", "A380", "Beluga XL"};

    public static ArrayList<Airport> airports = new ArrayList<>();

    /**
     * Private constructor for safety.
     */
    private Reference() {}
}
