package System.Aircraft.CargoTransporter;

import System.Aircraft.CargoTransporter.Package;

import java.util.ArrayList;

public class CargoTransporter {


    private String make;
    private String model;
    private Double capacity;

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

    public Double getCapacity(){
        return capacity;
    }

    public int[] getCargo() {
        return package;
    }

}



