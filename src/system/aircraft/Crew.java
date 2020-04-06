package system.aircraft;

/**
 * Crew member is a type of person, but
 * doesn't have seating arrangement, ticket, etc.
 * Has a role of captain, or flight attendant.
 */
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

    /**
     * Gets name
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets if is ginger
     * @return
     */
    @Override
    public boolean isGing() {
        return ginger;
    }

    /**
     * Gets role of crew member
     * @return
     */
    public String getRole() {
        return role;
    }
}
