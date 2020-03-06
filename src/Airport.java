import java.util.ArrayList;

public class Airport {
    private boolean towered;
    private int numRunways;

    private int capacity;
    private ArrayList<Aircraft> aircraft = new ArrayList<Aircraft>();

    public Airport() {

    }

    /**
     * Returns aircraft at airport.
     * @return ArrayList<Aircraft></Aircraft>
     */
    public ArrayList<Aircraft> getAircraft() {
        return this.aircraft;
    }

    /**
     * Returns if airport is towered.
     * @return boolean
     */
    public boolean isTowered() {
        return this.towered;
    }
}
