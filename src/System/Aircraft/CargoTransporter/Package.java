package System.Aircraft.CargoTransporter;

public class Package {


    private double weight;
    private String destination;


    /**
     * Constructor to create a package
     * @param weight weight of the package in lbs
     * @param destination destination airport
     */
    public Package(double weight, String destination){
        this.destination=destination;
        this.weight=weight;
    }

    Package(){}

    public String getDestination(){
        return destination;
    }

    public double getWeight(){
        return weight;
    }


}
