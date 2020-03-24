package System.Aircraft.Airliner;

import System.Aircraft.IAircraft;

import java.util.ArrayList;

public class Airliner implements IAircraft {
    private String make;
    private String model;

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
        souls.clear();

        for (int i = 0; i < bodies.size(); i++) {
            if (!bodies.get(i).isGing()) {
                souls.add(bodies.get(i));
            }
        }
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
}