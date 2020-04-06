package system;

import system.aircraft.IAircraft;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;

import java.util.ArrayList;

/**
 * Airport must have aircraft on it.
 * Has runways, towered or non-towered,
 * aircraft capacity,
 * Identified (3 letters)
 */
public class Airport {
    private String identifier;

    private boolean towered;
    private int numRunways;

    private int capacity;
    private ArrayList<IAircraft> aircraft;

    /**
     * Creates an airport with an identifier (used for reference)
     * @param identifier
     */
    public Airport(String identifier) {
        aircraft = new ArrayList<IAircraft>();
        this.identifier = identifier;
    }

    /**
     * Returns if airport is towered.
     * @return boolean
     */
    public boolean isTowered() {
        return towered;
    }

    /**
     * Setter for towered or not
     * @param b
     */
    public void isTowered(boolean b) {
        towered = b;
    }

    /**
     * Getter for capacity
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Identifier getter
     * @return
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Adds aircraft to arraylist
     * @param a
     */
    public void addAircraft(Airliner a) {
        aircraft.add(a);
    }

    /**
     * Adds aircraft to arraylist
     * @param c
     */
    public void addAircraft(CargoTransporter c) {
        aircraft.add(c);
    }

    /**
     * Returns aircraft at airport.
     * @return ArrayList<System.Aircraft.IAircraft></System.Aircraft.IAircraft>
     */
    public ArrayList<IAircraft> getAircraft() {
        return aircraft;
    }

    /**
     * Sets airport aircraft capacity
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
