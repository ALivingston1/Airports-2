package System.Aircraft;

import System.Aircraft.Airliner.IPerson;

public class Crew implements IPerson {
    private String name;
    private boolean ginger;

    private String role;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isGing() {
        return ginger;
    }

    public String getRole() {
        return role;
    }
}
