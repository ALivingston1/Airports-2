package System.Airliner;

import System.Airliner.IPerson;
import System.Airliner.Luggage;

import java.util.ArrayList;

public class Passenger implements IPerson {
    private String name;
    private boolean ginger;
    private String seat;

    private ArrayList<Luggage> luggage;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isGing() {
        return ginger;
    }
}
