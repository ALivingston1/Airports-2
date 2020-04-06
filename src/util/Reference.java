package util;

import system.Airport;

import java.util.ArrayList;

public class Reference {
    public static String[] airportList = {"ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR", "CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA", "MDW", "TPA", "PDX", "HNL"};
    public static String[] airlineList = {"Spirit", "American", "United", "SouthWest"};
    public static String[] make = {"Boeing", "Airbus"};
    public static String[] model = {"737", "747", "767", "777", "A300", "A330", "A350", "A380", "Beluga XL"};

    public static ArrayList<Airport> airports = new ArrayList<>();

    private Reference() {}
}
