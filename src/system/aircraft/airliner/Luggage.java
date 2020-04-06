package system.aircraft.airliner;

import system.aircraft.cargotransporter.Package;

/**
 * Each cargo transporter should have packages
 */
public class Luggage extends Package {

    private String owner;

    /**
     * Constructor to create an object of luggage, uses the package constructor and in addition adds an owner
     * @param weight Double with the weight of the luggage
     * @param destination the destination airport
     * @param owner The passenger the luggage belongs to
     */
    Luggage(double weight,String destination,String owner){
        super(weight,destination);
        this.owner=owner;

    }

    /**
     * Gets the owner of the package
     * @return
     */
    public String getOwner(){
        return owner;
    }


}
