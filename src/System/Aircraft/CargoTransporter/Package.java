package System.Aircraft.CargoTransporter;

public class Package {


    private double weight;
    private String destination;

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
