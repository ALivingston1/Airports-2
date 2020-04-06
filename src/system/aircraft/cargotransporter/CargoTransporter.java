package system.aircraft.cargotransporter;

import system.aircraft.IAircraft;

public class CargoTransporter implements IAircraft {
    private String make;
    private String model;
    private String origin;
    private String destination;

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    private String flightNumber;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    private double capacity;

    private int[] cargo;

    public CargoTransporter() {

    }

    /**
     * Constructor to create a cargo plane
     * @param make Make of plane
     * @param capacity  Capacity of plane in pounds
     * @param model model of aircraft
     * @param cargo array of what cargo the plane will contain
     */
    CargoTransporter(String make, double capacity, String model, int[] cargo){
        this.make=make;
        this.capacity=capacity;
        this.model=model;
        this.cargo=cargo;
    }



    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    public double getWeightCapacity(){
        return capacity;
    }

    public int[] getCargo() {
        return cargo;
    }

}


