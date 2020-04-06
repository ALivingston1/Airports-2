package system;

import system.aircraft.IAircraft;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;

import java.util.ArrayList;

public class Airport {
    private String identifier;

    private boolean towered;
    private int numRunways;

    private int capacity;
    private ArrayList<IAircraft> aircraft;

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

    public void isTowered(boolean b) {
        towered = b;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void addAircraft(Airliner a) {
        aircraft.add(a);
    }

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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
