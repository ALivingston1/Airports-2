package system.aircraft.airliner;

import system.aircraft.IAircraft;
import system.aircraft.IPerson;

import java.util.ArrayList;

/**
 * Basic airliner method.
 * Implements IAircraft, must have
 * make, model, etc.
 * Has a flight number, passenger list (bodies, souls),
 * weight capacity, passenger capacity,
 * origin, destination.
 */
public class Airliner implements IAircraft {
    private String make;
    private String model;
    private String airline;
    private String origin;
    private String destination;
    private String flightNumber;

    private double weightCapacity;
    private int passengerCapacity;

    private ArrayList<IPerson> bodies;
    private ArrayList<IPerson> souls;

    /**
     * Clears the list of souls.
     * Checks each body individually for a soul.
     * If they have a soul, add them to the list of souls.
     */
    public Airliner() {
//        souls.clear();
//
//        for (int i = 0; i < bodies.size(); i++) {
//            if (!bodies.get(i).isGing()) {
//                souls.add(bodies.get(i));
//            }
//        }
    }

    /**
     * Getter for airline name
     * @return
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Setter for airline name
     * @param airline
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * Getter for departure airport
     * @return
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Setter for departure airport
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Getter for destination airport
     * @return
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Getter for flight number
     * @return
     */
    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Setter for destination
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * getter for make of aircraft
     * @return
     */
    @Override
    public String getMake() {
        return make;
    }

    /**
     * Getter for model of aircraft
     * @return
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Getter for weight capacity
     * @return
     */
    @Override
    public double getWeightCapacity() {
        return weightCapacity;
    }

    /**
     * Getter for passenger capacity.
     * @return
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Getter for bodies (including gingers) on aircraft
     * @return
     */
    public ArrayList<IPerson> getBodies() {
        return bodies;
    }

    /**
     * Getter for souls on board aircraft
     * @return
     */
    public ArrayList<IPerson> getSouls() {
        return souls;
    }

    /**
     * Setter for make of aircraft
     * @param make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Setter for model of aircraft
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Setter for weight capacity of aircraft
     * @param weightCapacity
     */
    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    /**
     * Setter for passenger capacity of aircaft
     * @param passengerCapacity
     */
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Setter for flight number
     * @param flightNumber
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}