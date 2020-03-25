package System.Aircraft.CargoTransporter;

public class Package {


    private double weight;
    private String destination;

    Package(double weight, String destination){
        this.destination=destination;
        this.weight=weight;
    }

    public String getDestination(){
        return destination;
    }

    public double getWeight(){
        return weight;
    }


}
