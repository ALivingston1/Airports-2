package system;

import system.aircraft.IAircraft;

import java.util.ArrayList;

public class Airport {
    private boolean towered;
    private int numRunways;

    private int capacity;
    private ArrayList<IAircraft> aircraft;

    public Airport() {
        aircraft = new ArrayList<IAircraft>();
    }

    /**
     * Returns if airport is towered.
     * @return boolean
     */
    public boolean isTowered() {
        return towered;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns aircraft at airport.
     * @return ArrayList<System.Aircraft.IAircraft></System.Aircraft.IAircraft>
     */
    public ArrayList<IAircraft> getAircraft() {
        return aircraft;
    }

}
