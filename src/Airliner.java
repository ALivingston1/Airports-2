import java.lang.reflect.Array;
import java.util.ArrayList;

public class Airliner implements IAircraft {
    private String make;
    private String model;

    private double weightCapacity;
    private int passengerCapacity;

    private ArrayList<Person> bodies;
    private ArrayList<Person> souls;

    public Airliner() {
        addSouls();
    }

    @Override
    public String getMake() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public double getWeightCapacity() {
        return 0;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public ArrayList<Person> getBodies() {
        return bodies;
    }

    public ArrayList<Person> getSouls() {


    }

    /**
     * Clears the list of bodies.
     * Checks each body individually for a soul.
     * If they have a soul, add them to the list of souls.
     */
    private void addSouls() {
        souls.clear();

        for (int i = 0; i < bodies.size(); i++) {
            if (!bodies.get(i).isGing()) {
                souls.add(bodies.get(i));
            }
        }
    }

}