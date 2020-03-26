package System.Aircraft;

import System.Aircraft.Airliner.IPerson;

public class Crew implements IPerson {
    private String name;
    private boolean ginger;

    private String role;


    /**
     * Creates a crew member inhereted from the interface of person adding their role on the plane to control the planes total capacity
     * @param name Name of crew member
     * @param ginger If ginger to take away from the soul count
     * @param role which job they have on the plane
     */
    Crew(String name,boolean ginger,String role){
        this.name=name;
        this.ginger=ginger;
        this.role=role;
    }

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
