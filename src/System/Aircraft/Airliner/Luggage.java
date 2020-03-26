package System.Aircraft.Airliner;

import System.Aircraft.CargoTransporter.Package;

public class Luggage extends Package {

    private String owner;


    Luggage(double weight,String destination,String owner){
        super(weight,destination);
        this.owner=owner;

    }

    public String getOwner(){
        return owner;
    }


}
