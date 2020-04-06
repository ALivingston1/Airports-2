package system.aircraft.airliner;

import system.aircraft.IAircraft;
import system.aircraft.IPerson;

import java.util.ArrayList;

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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getWeightCapacity() {
        return weightCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public ArrayList<IPerson> getBodies() {
        return bodies;
    }

    public ArrayList<IPerson> getSouls() {
        return souls;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}