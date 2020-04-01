package system.aircraft.cargotransporter;

import system.aircraft.IAircraft;

public class CargoTransporter implements IAircraft {

    private String make;
    private String model;
    private double capacity;

    private int[] cargo;


    CargoTransporter(String make,double capacity,String model,int[] cargo){
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


