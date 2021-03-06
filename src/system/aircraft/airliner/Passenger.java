package system.aircraft.airliner;

import system.aircraft.IPerson;

/**
 * Should be passengers on board an aircraft
 * with name, is ginger, seat number, and their luggage.
 */
public class Passenger implements IPerson {
    private String name;
    private boolean ginger;
    private String seat;

    private int[] luggage;


    /**
     * Passenger constructor creates a passenger inhereted from  person
     * @param name name of passenger
     * @param ginger if the person is ginger to take away from the count of souls on the plane
     * @param seat which seat number is assigned to the passenger
     * @param luggage the array of luggage that they have
     */
    Passenger(String name,boolean ginger,String seat,int[] luggage){
        this.name=name;
        this.ginger=ginger;
        this.seat=seat;
        this.luggage=luggage;
        
    }

    /**
     * Getter for name
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for is ginger
     * @return
     */
    @Override
    public boolean isGing() {
        return ginger;
    }

    /**
     * Getter for seat type
     * @return
     */
    public String getSeat(){
        return seat;
    }

}
